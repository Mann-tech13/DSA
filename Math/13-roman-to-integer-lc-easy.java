class Solution {
    public  int romanToInt(String s) {
		int sum = 0;
		for(int i=0;i<s.length()-1;i++) {
			sum = sum + getValue(s.charAt(i));
			if(getValue(s.charAt(i)) < getValue(s.charAt(i+1))) {
				sum = sum - getValue(s.charAt(i))*2;
			}
		}
		sum = sum + getValue(s.charAt(s.length()-1));
		return sum;
	}
	
    private  int getValue(char c){
        switch(c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}