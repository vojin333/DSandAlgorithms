package recursion;

public class HanoiTowerApp {

	public static int nDisks = 2;
	
	public static void main(String[] args) {
		//call to do tower
		doTowers(nDisks, 'A', 'B', 'C');
		
	}
	
	public static void doTowers(int topN, char from, char inter, char to) {
		if (topN == 1) {
			//Base case moving top disk from A->B
			System.out.println("Disk 1 from " + from + " to " + to);
		} else {
			//case moving the disk under from A->C
			doTowers(topN - 1, from, to, inter);
			System.out.println("Disk " + topN + " from " + from + " to " + to);
			//case moving those two disks on their place small disk on top of the bigger B->C
			doTowers(topN - 1, inter, from, to);
		}
	}
			
}
