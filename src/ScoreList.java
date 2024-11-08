import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ScoreList {
		private ArrayList<Score> topscores= new ArrayList<>();
		
		//constructor 
		public ScoreList() {
			
		}
		
		//methods 
		public void  updateTopScores(Score score) {
			topscores.add(score);
			Collections.sort(topscores, Comparator.comparingInt(Score::getScore).reversed()); // sort scores to descending order
			while (topscores.size() > 5) {
	            topscores.remove(topscores.size() - 1); // Remove the lowest score when more than 5
	        }
		}
		
		//get scores from file 
		public void readTopScores() {
	        try (BufferedReader br = new BufferedReader(new FileReader("src/TopScores.txt"))){
	        	 
	        	String line;
	            
	        	while ((line = br.readLine()) != null) {
	                // Split the line into fields using a comma as a delimiter
	                String[] fields = line.split(",");
	                if (fields.length == 2) {
	                    String name = fields[0].trim();
	                    int scoreValue = Integer.parseInt(fields[1].trim());
	                    Score score = new Score(name, scoreValue);
	                    updateTopScores(score);
	                }
	            }
	            br.close();
	        
	        } catch (IOException  | NumberFormatException e) {
	            System.out.println("Error getting top scores");
	        }
	    }
		
		//save scores to file 
		public void saveTopScores() {
	        
			try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/TopScores.txt"))) {
			    for (Score score : topscores) {
			        // Write each score to the file
			        writer.write(String.format("%s, %d%n", score.getName(), score.getScore()));
			    }
			    
			} catch (IOException e) {
			    System.out.println("Error writing to file!");
			}
	    }
		
	
		//toString (will display topscorelist)
		public String toString() {
			String topscoresdisplay = "\n----------Top Score Lists------------\n";
			 
			for (Score score : topscores) {
			        topscoresdisplay += score.getName() + ",  "+ score.getScore() +"\n";
			    }
			 
			return topscoresdisplay;
		}
		
}