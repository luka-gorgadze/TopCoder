import java.util.Arrays;

public class AccessChanger {

	public String[] convert(String[] program) {
		String[] transformedProgram = new String[program.length];
		String code;
		String comment;
		int indexOfSlash;

		for (int i = 0; i < program.length; i++) {
			indexOfSlash = program[i].indexOf("//");
			if (indexOfSlash == -1) {
				transformedProgram[i] = program[i].replace("->", ".");
			} else {
				// if a line contains slash we need to call replace only for code part
				code = program[i].substring(0, indexOfSlash);
				code = code.replace("->", ".");
				comment = program[i].substring(indexOfSlash, program[i].length());
				transformedProgram[i] = code + comment;
			}
		}

		return transformedProgram;
	}

	public static void main(String[] args) {
		AccessChanger ac = new AccessChanger();
		String[] input = { "Test* t = new Test();", "t->a = 1;", "t->b = 2;", "t->go(); // a=1, b=2 --> a=2, b=3" };
		System.out.println(Arrays.toString(ac.convert(input)));
	}

}
