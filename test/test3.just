program TestProgram {
	int x;
	boolean success;
	
	int doIt(byref int aParam) {
		boolean b = true;
		boolean c = false;
		int d = 13;
		d = 12;
		aParam = 4;
		if ( b == true ) {
			int k;
			b = false;
			k = 10;
		}
		int k = 5000;
		
		foo(25);
	}
	
	int foo(int a) {
		a = 25;
	}
	
	int foo(boolean b) {
	}
}