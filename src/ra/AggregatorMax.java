package ra;

/**
 * Created by DC on 3/29/14.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.Function;
import dao.Datum;
import dao.Tuple;

/**
 * Aggregate max function
 * @author Asia
 *
 */
public class AggregatorMax extends Aggregator {

    private Map<String, Datum> maxMap;
    private Expression paraExpr;
    private EvaluatorArithmeticExpres eval;
    
    public AggregatorMax(Function funcIn, String[] groupByNamesIn) {
        super(funcIn, groupByNamesIn);

        maxMap = new HashMap<String, Datum>();
        eval = new EvaluatorArithmeticExpres();
        
        @SuppressWarnings("unchecked")
        List<Expression> paraList = funcIn.getParameters().getExpressions();
        if (paraList.size() > 1)
            throw new UnsupportedOperationException("Not supported yet.");
        else
            paraExpr = paraList.get(0);
    }

    @Override
    public void aggregate(Tuple tuple, String key) {
        Datum newVal = eval.parse(paraExpr, tuple);
        if (!maxMap.containsKey(key)) {
            //insert new
            maxMap.put(key, newVal);
        } else { //update old, max
            Datum oldVal = maxMap.get(key);
            //can not max Bool, String, Date
            if(oldVal.compareTo(newVal)<0)
            	maxMap.put(key, newVal);
        }
    }

    @Override
    public Datum getValue(String key) {
        return maxMap.get(key);
    }
}
