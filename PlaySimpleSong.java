package program2;

import stdlib.*;
import algs31.BinarySearchST;

public class PlaySimpleSong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchST<String, Double> frequencies = new BinarySearchST<String,Double>();
		StdIn.fromFile("data/notes_frequencies.txt");
		
		for(int i=0; !StdIn.isEmpty(); i++){
			if(StdIn.hasNextLine()){
				String freq = StdIn.readLine();
				String[] freqArray = freq.split("\t");
				frequencies.put(freqArray[0].trim(), Double.parseDouble(freqArray[1]));
						
			}
		}
			
//		StdIn.fromFile("data/sample_simple_song.txt");
		StdIn.fromFile("data/lotr.txt");
			
			for(int i=0; !StdIn.isEmpty(); i++){
 					String cancion = StdIn.readLine();
					String[] lyricsArray = cancion.split(" ");
					String music = lyricsArray[0];
					playTone(frequencies.get(music),Double.parseDouble(lyricsArray[1]));
							
			}	
		}
			public static void playTone(double frequency, double duration) {
				final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
				final double[] slices = new double[sliceCount+1];
				for (int i = 0; i <= sliceCount; i++) {
					slices[i] = Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
				}
				StdAudio.play(slices);
			}
			
			
}
	

