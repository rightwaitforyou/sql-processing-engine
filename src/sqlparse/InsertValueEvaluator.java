package sqlparse;

import java.util.Date;

import net.sf.jsqlparser.expression.AllComparisonExpression;
import net.sf.jsqlparser.expression.AnyComparisonExpression;
import net.sf.jsqlparser.expression.CaseExpression;
import net.sf.jsqlparser.expression.DateValue;
import net.sf.jsqlparser.expression.DoubleValue;
import net.sf.jsqlparser.expression.ExpressionVisitor;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.expression.InverseExpression;
import net.sf.jsqlparser.expression.JdbcParameter;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.NullValue;
import net.sf.jsqlparser.expression.Parenthesis;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.TimeValue;
import net.sf.jsqlparser.expression.TimestampValue;
import net.sf.jsqlparser.expression.WhenClause;
import net.sf.jsqlparser.expression.operators.arithmetic.Addition;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseAnd;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseOr;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseXor;
import net.sf.jsqlparser.expression.operators.arithmetic.Concat;
import net.sf.jsqlparser.expression.operators.arithmetic.Division;
import net.sf.jsqlparser.expression.operators.arithmetic.Multiplication;
import net.sf.jsqlparser.expression.operators.arithmetic.Subtraction;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.Between;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.ExistsExpression;
import net.sf.jsqlparser.expression.operators.relational.GreaterThan;
import net.sf.jsqlparser.expression.operators.relational.GreaterThanEquals;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.IsNullExpression;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import net.sf.jsqlparser.expression.operators.relational.Matches;
import net.sf.jsqlparser.expression.operators.relational.MinorThan;
import net.sf.jsqlparser.expression.operators.relational.MinorThanEquals;
import net.sf.jsqlparser.expression.operators.relational.NotEqualsTo;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.SubSelect;
import dao.Datum;
import dao.DatumDate;
import dao.DatumDouble;
import dao.DatumFactory;
import dao.DatumLong;
import dao.DatumString;
import dao.DatumType;

public class InsertValueEvaluator implements ExpressionVisitor {
	private Datum cell;

	public Datum getCell() {
		Datum res = cell;
		cell = null;
		return res;
	}

	@Override
	public void visit(NullValue arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void visit(Function arg0) {
		if(arg0.getName().equalsIgnoreCase("DATE")){
			String para = arg0.getParameters().getExpressions().get(0).toString();
			String date = para.substring(1, para.length()-1);
			cell = DatumFactory.create(date, DatumType.Date);
		}
	}

	@Override
	public void visit(InverseExpression arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void visit(JdbcParameter arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void visit(DoubleValue arg0) {
		cell = new DatumDouble(arg0.getValue());
	}

	@Override
	public void visit(LongValue arg0) {
		cell = new DatumLong(arg0.getValue());
	}

	@SuppressWarnings("deprecation")
	@Override
	public void visit(DateValue arg0) {
		Date date = arg0.getValue();
		cell = new DatumDate(date.getYear(), date.getMonth(), date.getDay());
	}

	@Override
	public void visit(TimeValue arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void visit(TimestampValue arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void visit(Parenthesis arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void visit(StringValue arg0) {
		cell = new DatumString(arg0.getValue());
	}

	@Override
	public void visit(Addition arg) {
		arg.getLeftExpression().accept(this);
		Datum left = getCell();

		arg.getRightExpression().accept(this);
		Datum right = getCell();

		cell = Datum.calcDatum(left, right, 1);
	}

	@Override
	public void visit(Division arg) {
		arg.getLeftExpression().accept(this);
		Datum left = getCell();

		arg.getRightExpression().accept(this);
		Datum right = getCell();

		cell = Datum.calcDatum(left, right, 4);
	}

	@Override
	public void visit(Multiplication arg) {
		arg.getLeftExpression().accept(this);
		Datum left = getCell();

		arg.getRightExpression().accept(this);
		Datum right = getCell();

		cell = Datum.calcDatum(left, right, 3);
	}

	@Override
	public void visit(Subtraction arg) {
		arg.getLeftExpression().accept(this);
		Datum left = getCell();

		arg.getRightExpression().accept(this);
		Datum right = getCell();

		cell = Datum.calcDatum(left, right, 2);
	}

	@Override
	public void visit(AndExpression arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(OrExpression arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(Between arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(EqualsTo arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(GreaterThan arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(GreaterThanEquals arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(InExpression arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(IsNullExpression arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(LikeExpression arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(MinorThan arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(MinorThanEquals arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(NotEqualsTo arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(Column arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(SubSelect arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(CaseExpression arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(WhenClause arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(ExistsExpression arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(AllComparisonExpression arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(AnyComparisonExpression arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(Concat arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(Matches arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(BitwiseAnd arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(BitwiseOr arg0) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void visit(BitwiseXor arg0) {
		throw new UnsupportedOperationException();

	}

}
