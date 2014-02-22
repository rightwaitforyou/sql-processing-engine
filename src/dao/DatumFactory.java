package dao;

public class DatumFactory {
	public static Datum create(String dataIn, DatumType type){
		switch(type){
		case Long:
			return new DatumLong(dataIn);
		case Int:
			return new DatumInt(dataIn);
		case Float:
			return new DatumFloat(dataIn);
		case Bool:
			return new DatumBool(dataIn);
		case String:
			return new DatumString(dataIn);
		case Date:
			return new DatumDate(dataIn);
		default:
			try {
				throw new Exception("unknown datum type : " + type);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}