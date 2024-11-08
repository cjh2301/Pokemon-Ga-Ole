
public class Score {
		private int score; 
		private String name; 
		
		//constructor
		public Score( ) {
			
		}
		public Score(String name, int score) {
			this.name = name;
			this.score = score;
		
		}
		
		//setter getters
		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		
		//toString 
		public String toString() {
			return String.format("/nName : %s , Score : %d", name, score);
		}
		
	
		
}