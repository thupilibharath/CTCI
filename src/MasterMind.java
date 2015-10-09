/**
 * Created by Bharath on 8/19/15.
 */

//BIT MASK IMPORTANT

public class MasterMind {

    void findHits(String guess, String solution){
        int solution_mask = 0;
        int hits = 0;
        int pseudo_hits = 0;
        for(int i=0;i<4;i++){
            solution_mask |= 1<<((solution.charAt(i) - 'A'));
        }

        for(int i=0;i<4;i++){
            if(guess.charAt(i)==solution.charAt(i)){
                hits++;
            }
            else if((solution_mask &(1<<(guess.charAt(i)-'A')))>=1){
                pseudo_hits++;
            }
        }

        System.out.println("No of hits is : "+hits);
        System.out.println("No of pseudo hits is : "+pseudo_hits);
    }

    public static void main(String[] args){
        MasterMind m1 = new MasterMind();
        m1.findHits("YRGB", "RGGB");
    }
}
