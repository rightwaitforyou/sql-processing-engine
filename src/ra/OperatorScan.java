/**
 * 
 */
package ra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import common.TimeCalc;

import net.sf.jsqlparser.parser.CCJSqlParser;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import dao.Schema;
import dao.Tuple;

/**
 * @author Asia
 *
 */
public class OperatorScan implements Operator {

	private BufferedReader inputReader;
	private File file;
	private Schema schema;
	private final static int BLOCKSIZE =  100000;  // 100000000;	//100MB
	
	public OperatorScan(File f, Schema schemaIn){
		file = f;
		schema = schemaIn;
		reset();
	}
	
	@Override
	public List<Tuple> readOneBlock() {
		List<Tuple> tuples = new LinkedList<Tuple>();
//		StringBuilder sb = new StringBuilder();
//		char[] content = new char[BLOCKSIZE];
		try {
			int i=0;
			String line;
			while(i<=BLOCKSIZE&&(line=inputReader.readLine())!=null){
				tuples.add(new Tuple(line, schema));
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tuples;	
	}
	
	@Override
	public Tuple readOneTuple() {
		checkInput();
		Tuple tuple = null;
		try {
			String line = inputReader.readLine();
			if(line==null)
				tuple = null;			
			else
				tuple = new Tuple(line, schema);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tuple;
	}

	@Override
	public void reset() {
		try {
			inputReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			inputReader = null;
		}
	}
	
	/**
	 * Check inputReader whether is null
	 * @return
	 */
	private boolean checkInput(){
		if(inputReader==null){
			try {
				throw new Exception("inputReader is null!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}else
			return true;
	}

	
	public static void main(String[] args){
		System.out.println("test");
		String text = "wgaweg|gaweg|bqeqwg|12|fqweg2|23fasdf|fs.w';eg \n\n qwegqwdasg\n asdfasd";
		System.out.println(text+"\n\n\n");
		
		StringReader stream = new StringReader("CREATE TABLE ORDERS (orderkey INT,custkey INT,orderstatus CHAR(1),totalprice DECIMAL,orderdate  DATE,orderpriority CHAR(15),clerk CHAR(15),shippriority INT,comment VARCHAR(79));");
		CCJSqlParser parser = new CCJSqlParser(stream);
		
		try {
			CreateTable ct = parser.CreateTable();
			OperatorScan scan = new OperatorScan(new File("data/tpch/orders.tbl"), new Schema(ct, null));
			List<Tuple> tuples;
			int i=0;
			TimeCalc.begin(0);
			do{
				i++;
				tuples = scan.readOneBlock();
			}while(tuples.size()!=0);
			TimeCalc.end(0);
			
			
			scan = new OperatorScan(new File("data/tpch/orders.tbl"), new Schema(ct, null));
			TimeCalc.begin(1);
			tuples = new LinkedList();
			Tuple t;
			while((t = scan.readOneTuple())!=null)
				tuples.add(t);
			System.out.println(tuples.size());
			TimeCalc.end(1);
			System.out.println("End");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
