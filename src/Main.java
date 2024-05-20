import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] split = input.split(",");
        List<Integer> pages = new ArrayList<>();
        for(int i = 0; i < split.length; i++)
        	pages.add(Math.abs(Integer.parseInt(split[i]))); 
        
        Frame A = new Frame('A');
        Frame B = new Frame('B');
        Frame C = new Frame('C');
        
        List<Character> output = new LinkedList<>();
        int fails = 0;
        
        List<Frame> frames = new ArrayList<>();
        frames.add(A);
        frames.add(B);
        frames.add(C);
        
        
        for(int i = 0; i < pages.size(); i++) {
        	
        	
        	
        	
        	if(A.getPage() == pages.get(i)) {
        		output.add('-');
        		
        		A.zeroFrozen();
        		A.setUsed(true);
        	}
        	else if(B.getPage() == pages.get(i)) {
        		output.add('-');
        		
        		B.zeroFrozen();
        		B.setUsed(true);
        	}
        	else if(C.getPage() == pages.get(i)) {
        		output.add('-');
        		
        		C.zeroFrozen();
        		C.setUsed(true);
        	}
        	else if(A.getPage() == 0) { A.setPage(pages.get(i)); output.add('A'); A.resetFrozen(); fails++;}
        	else if(B.getPage() == 0) { B.setPage(pages.get(i)); output.add('B'); B.resetFrozen(); fails++;}
        	else if(C.getPage() == 0) { C.setPage(pages.get(i)); output.add('C'); C.resetFrozen(); fails++;}
        	
        	else if(A.isFrozen() && B.isFrozen() && C.isFrozen()) {
        		output.add('*');
        		fails++;
        	}
        	
        	else {
        		boolean end = false;
        		int idx = 0;
        		while(!end) {
        			if(frames.get(idx).isUsed()) {
        				frames.get(idx).setUsed(false);
        				frames.add(frames.remove(idx));
        				
        			}
        			
        			else if(frames.get(idx).isFrozen())
        				idx++;
        			else end = true;
        		}
        		
        		output.add(frames.get(idx).getName());
        		frames.get(idx).setPage(pages.get(i));
        		frames.get(idx).resetFrozen();
        		fails++;
        		frames.add(frames.remove(idx));
        	}
        	
        	
        	if(A.isFrozen())
        		A.decreaseFrozen();
        	if(B.isFrozen())
        		B.decreaseFrozen();
        	if(C.isFrozen())
        		C.decreaseFrozen();
        }
        
        for(char c : output)
        	System.out.print(c);
        System.out.println();
        System.out.println(fails);
    
    }
}