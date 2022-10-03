import java.util.*;

public class RandomPlayer extends Player{
	
	RandomPlayer(String name){
		super(name);
	}
	
	public int[] getMove(int[] pileSizes){
		int[] move;
		Random random = new Random();
		int pileIndex = random.nextInt(pileSizes.length) ;
		while(pileSizes[pileIndex]==0){
			pileIndex = random.nextInt(pileSizes.length);
		}
		//pileSizes[pileIdx]= random.nextInt(pileSizes.length);
		move = new int[] {pileIndex,(random.nextInt(pileSizes[pileIndex])+1)};
		
		return move;
	}
	
}
