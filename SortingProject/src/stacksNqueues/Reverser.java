package stacksNqueues;

public class Reverser {

	private String input;
	private String output;
	
	public Reverser(String in) {
		input = in;
	}
	
	
	public String doRev() {
		int stackSize = input.length();
		StackX stack = new StackX(stackSize);
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			stack.push(ch);
		}
		output = "";
		while (!stack.isEmpty()) {
			char ch = stack.pop();
			output = output + ch;
		}
		
		return output;
	}
	
	public void checkBrackets() {
		int stackSize = input.length();
		StackX stack = new StackX(stackSize);
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			 switch (ch) {
			case '{':
			case '[':
			case '(':
				stack.push(ch);
				break;

			case '}':
			case ']':
			case ')':
				if (!stack.isEmpty()) {
					char chx = stack.pop();
					if ((ch == '{' && chx != '}')
						|| (ch == '[' && chx != ']')
						|| (ch == '(' && chx != ')')) {
						System.out.println("Error : " + ch + " at " + i);
					}
				} else {
					System.out.println("Error : " + ch + " at " + i);
					break;
				}
			default:
				break;
			}
		}
		
		if (!stack.isEmpty()) {
			System.out.println("Error: missing right delimiter");
		}
	}
}
