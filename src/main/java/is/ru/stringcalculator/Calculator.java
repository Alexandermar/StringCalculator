package is.ru.stringcalculator;

public class Calculator{
	
	public static int add(String text){
		if(text.equals(""))
			return 0;
		else
			if(text.contains(",") || text.contains("\n")){
				text = text.replaceAll("\n", ",");
				String numbers[] = text.split(",");
				return sum(numbers) ;
			}
			
			else{
				return toInt(text);
			}
	}
	
	
	private static int toInt(String number){
		return Integer.parseInt(number);
	}
	
	private static int sum(String [] numbers){
		
		checkNegative(numbers);
		int total = 0;
		
			for(String number : numbers){
				int indexNumber = toInt(number);
				
				total += toInt(number);
			}
			
			return total;
	}
	
	private static void checkNegative(String [] numbers){

    String negatives = "";
    boolean isNegative = false;
    for(String number : numbers){
        if(toInt(number) < 0){

            if(!isNegative){
                isNegative = true;
                negatives = negatives + number;
            }
            else{
                negatives = negatives + "," + number;
            }
        }
    }
    if(isNegative){
      throw new IllegalArgumentException("Negatives are not allwoed: " + negatives);
    }
  }
	
}