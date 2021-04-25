
public class MyUnit {

	public String contatenate(String string, String string2) {
		//return (string == null ? "" : string) + (string2 == null ? "" : string2);
		String s1 = string;
		String s2 = string2;
		if (s1 == null)
			s1 = "";
		if (s2 == null)
			s2 = "";
		return s1 + s2;
	}

}
