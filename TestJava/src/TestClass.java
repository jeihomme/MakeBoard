public class TestClass {
	public int test(String skill, String[] skill_trees) {
		int res = 0;
		
		skill = "CBD";
		skill_trees[0] = "BACDE";
		skill_trees[1] = "CBADF";
		skill_trees[2] = "AECB";
		skill_trees[3] = "BDA";
		
		String[] skill_word; // 스트링을 담을 배열
		String[] skill_trees_word; // 스트링을 담을 배열

		for(int i = 0; i<skill_trees[i].length(); i++) {
			//사실상 가장 간단함
			skill_word = skill.split(""); //배열에 한글자씩 저장하기
					
			for(int j=0;j<skill_word.length;j++) { //출력
			    System.out.println(skill_word[j]);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		TestClass a = new TestClass();
		
		String skill = null;
		String[] skill_trees = null;
		
		int b = a.test(skill, skill_trees);
		
		System.out.println(b);
	}
}

