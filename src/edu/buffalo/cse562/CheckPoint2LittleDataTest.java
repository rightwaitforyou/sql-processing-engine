package edu.buffalo.cse562;

import io.FileAccessor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.Schema;
import dao.Tuple;

public class CheckPoint2LittleDataTest {

	private final static String TestFileDir = "test/cp2_littleBig";
	private final static String IndexDirStr = "test/MyIndexManager";
	private final static File SchemaFile =  new File("test/Checkpoint3DataTest/tpch_schemas.sql");
	
	@Before
	public void precomputation(){
		List<File> sqls = new ArrayList<File>();
		sqls.add(SchemaFile);
		Main.precompute(IndexDirStr, new File(TestFileDir), sqls);
	}
	
	@After
	public void end(){
		
	}
	
	@Test
	public void testTestSpecificSQL_tpch07a() {
		String sqlPath = TestFileDir + "/" + "tpch07a.sql";
		String resultPath = TestFileDir + "/" + "tpch07a.expected.dat";
		
		List<Tuple> results = Main.testSpecificSQL(TestFileDir, IndexDirStr,  sqlPath);
		if(results.size()>0){
			Schema schema = results.get(0).getSchema();	
			List<String> correctResults = FileAccessor.getInstance().readAllLines(resultPath);
			
			for(int i=0; i<results.size(); i++){
				System.out.println(correctResults.get(i)+"\n"+results.get(i)+"\n");	
				//Assert.assertEquals(results.get(i).toString(), correctResults.get(i));
			}

		}else
			Assert.fail("0 result.");
	}
	

	
	@Test
	public void testTestSpecificSQL_tpch10a() {
		String sqlPath = TestFileDir + "/" + "tpch10a.sql";
		String resultPath = TestFileDir + "/" + "tpch10a.expected.dat";
		
		List<Tuple> results = Main.testSpecificSQL(TestFileDir, IndexDirStr,  sqlPath);
		if(results.size()>0){

			List<String> correctResults = FileAccessor.getInstance().readAllLines(resultPath);
			
			for(int i=0; i<results.size(); i++){
				if(i<correctResults.size()){
					System.out.println(correctResults.get(i));
					System.out.println(results.get(i)+"\n");
				}
				else
					Assert.fail("Reuslt size doens't match!");
				//Assert.assertEquals(results.get(i), correctResults.get(i).toString());
			}

		}else
			Assert.fail("0 result.");
	}
	
	
	@Test
	public void testTestSpecificSQL_tpch10b() {
		String sqlPath = TestFileDir + "/" + "tpch10b.sql";
		String resultPath = TestFileDir + "/" + "tpch10b.expected.dat";
		
		List<Tuple> results = Main.testSpecificSQL(TestFileDir, IndexDirStr,  sqlPath);
		if(results.size()>0){

			List<String> correctResults = FileAccessor.getInstance().readAllLines(resultPath);
			
			for(int i=0; i<results.size(); i++){
				if(i<correctResults.size()){
					System.out.println(correctResults.get(i));
					System.out.println(results.get(i)+"\n");
				}else
					Assert.fail("Reuslt size doens't match!");
				//Assert.assertEquals(results.get(i), correctResults.get(i).toString());
			}

		}else
			Assert.fail("0 result.");
	}
	
	
	@Test
	public void testTestSpecificSQL_tpch10c() {
		String sqlPath = TestFileDir + "/" + "tpch10c.sql";
		String resultPath = TestFileDir + "/" + "tpch10c.expected.dat";
		
		List<Tuple> results = Main.testSpecificSQL(TestFileDir, IndexDirStr,  sqlPath);
		if(results.size()>0){

			List<String> correctResults = FileAccessor.getInstance().readAllLines(resultPath);
			
			for(int i=0; i<results.size(); i++){
				if(i<correctResults.size()){
					System.out.println(correctResults.get(i));
					System.out.println(results.get(i)+"\n");
				}else
					Assert.fail("Reuslt size doens't match!");
				//Assert.assertEquals(results.get(i), correctResults.get(i).toString());
			}

		}else
			Assert.fail("0 result.");
	}
	
	@Test
	public void testTestSpecificSQL_tpch10d() {
		String sqlPath = TestFileDir + "/" + "tpch10d.sql";
		String resultPath = TestFileDir + "/" + "tpch10d.expected.dat";
		
		List<Tuple> results = Main.testSpecificSQL(TestFileDir, IndexDirStr,  sqlPath);
		if(results.size()>0){

			List<String> correctResults = FileAccessor.getInstance().readAllLines(resultPath);
			
			for(int i=0; i<results.size(); i++){
				if(i<correctResults.size()){
					System.out.println(correctResults.get(i));
					System.out.println(results.get(i)+"\n");
				}else
					Assert.fail("Reuslt size doens't match!");
				//Assert.assertEquals(results.get(i), correctResults.get(i).toString());
			}

		}else
			Assert.fail("0 result.");
	}
	
	@Test
	public void testTestSpecificSQL_tpch12a() {
		String sqlPath = TestFileDir + "/" + "tpch12a.sql";
		String resultPath = TestFileDir + "/" + "tpch12a.expected.dat";
		
		List<Tuple> results = Main.testSpecificSQL(TestFileDir, IndexDirStr,  sqlPath);
		if(results.size()>0){

			List<String> correctResults = FileAccessor.getInstance().readAllLines(resultPath);
			
			for(int i=0; i<results.size(); i++){	
				Assert.assertEquals(correctResults.get(i), results.get(i).toString());
			}

		}else
			Assert.fail("0 result.");
	}
	
	
	
	@Test
	public void testTestSpecificSQL_tpch12b() {
		String sqlPath = TestFileDir + "/" + "tpch12b.sql";
		String resultPath = TestFileDir + "/" + "tpch12b.expected.dat";
		
		List<Tuple> results = Main.testSpecificSQL(TestFileDir, IndexDirStr,  sqlPath);
		if(results.size()>0){

			List<String> correctResults = FileAccessor.getInstance().readAllLines(resultPath);
			
			for(int i=0; i<results.size(); i++){	
				Assert.assertEquals(correctResults.get(i), results.get(i).toString());
			}

		}else
			Assert.fail("0 result.");
	}
	
	
	
	
	@Test
	public void testTestSpecificSQL_tpch12c() {
		String sqlPath = TestFileDir + "/" + "tpch12c.sql";
		String resultPath = TestFileDir + "/" + "tpch12c.expected.dat";
		
		List<Tuple> results = Main.testSpecificSQL(TestFileDir, IndexDirStr,  sqlPath);
		if(results.size()>0){

			List<String> correctResults = FileAccessor.getInstance().readAllLines(resultPath);
			
			for(int i=0; i<results.size(); i++){		
				Assert.assertEquals(correctResults.get(i), results.get(i).toString());
			}

		}else
			Assert.fail("0 result.");
	}
	
	
	
	
	@Test
	public void testTestSpecificSQL_tpch12d() {
		String sqlPath = TestFileDir + "/" + "tpch12d.sql";
		String resultPath = TestFileDir + "/" + "tpch12d.expected.dat";
		
		List<Tuple> results = Main.testSpecificSQL(TestFileDir, IndexDirStr,  sqlPath);
		if(results.size()>0){

			List<String> correctResults = FileAccessor.getInstance().readAllLines(resultPath);
			
			for(int i=0; i<results.size(); i++){
				Assert.assertEquals(correctResults.get(i), results.get(i).toString());
			}

		}else
			Assert.fail("0 result.");
	}
	
	

	@Test
	public void testTestSpecificSQL_tpch16a() {
		String sqlPath = TestFileDir + "/" + "tpch16a.sql";
		String resultPath = TestFileDir + "/" + "tpch16a.expected.dat";
		
		List<Tuple> results = Main.testSpecificSQL(TestFileDir, IndexDirStr,  sqlPath);
		if(results.size()>0){

			List<String> correctResults = FileAccessor.getInstance().readAllLines(resultPath);
			
			for(int i=0; i<results.size(); i++){		
				Assert.assertEquals(correctResults.get(i), results.get(i).toString());
			}

		}else
			Assert.fail("0 result.");
	}
	
	@Test
	public void testTestSpecificSQL_tpch16b() {
		String sqlPath = TestFileDir + "/" + "tpch16b.sql";
		String resultPath = TestFileDir + "/" + "tpch16b.expected.dat";
		
		List<Tuple> results = Main.testSpecificSQL(TestFileDir, IndexDirStr,  sqlPath);
		if(results.size()>0){

			List<String> correctResults = FileAccessor.getInstance().readAllLines(resultPath);
			
			for(int i=0; i<results.size(); i++){	
				Assert.assertEquals(correctResults.get(i), results.get(i).toString());
			}

		}else
			Assert.fail("0 result.");
	}
	
	@Test
	public void testTestSpecificSQL_tpch16c() {
		String sqlPath = TestFileDir + "/" + "tpch16c.sql";
		String resultPath = TestFileDir + "/" + "tpch16c.expected.dat";
		
		List<Tuple> results = Main.testSpecificSQL(TestFileDir, IndexDirStr,  sqlPath);
		if(results.size()>0){

			List<String> correctResults = FileAccessor.getInstance().readAllLines(resultPath);
			
			for(int i=0; i<results.size(); i++){		
				Assert.assertEquals(correctResults.get(i), results.get(i).toString());
			}

		}else
			Assert.fail("0 result.");
	}
	
	
	@Test
	public void testTestSpecificSQL_tpch16d() {
		String sqlPath = TestFileDir + "/" + "tpch16d.sql";
		String resultPath = TestFileDir + "/" + "tpch16d.expected.dat";
		
		List<Tuple> results = Main.testSpecificSQL(TestFileDir, IndexDirStr,  sqlPath);
		if(results.size()>0){

			List<String> correctResults = FileAccessor.getInstance().readAllLines(resultPath);
			
			for(int i=0; i<results.size(); i++){
				Assert.assertEquals(correctResults.get(i), results.get(i).toString());
			}

		}else
			Assert.fail("0 result.");
	}
}
