package first.controller.test;
/**
 * 1 3 5 7菱形图
 * @author Administrator
 *
 */
public class Test06 {

	public static void main(String[] args) {
		
		for(int i=4;i>=0;i--){
			for(int j=0;j<9;j++){
				if((i<=j)&&(i+j)<9){
					System.out.print(" * ");
				}else{
					System.out.print("   ");
				}
			}
			System.out.println("");
		}
		
		for(int i=1;i<5;i++){
			for(int j=0;j<9;j++){
				if((i<=j)&&(i+j)<9){
					System.out.print(" * ");
				}else{
					System.out.print("   ");
				}
			}
			System.out.println("");
		}
		
		for(int i=4;i>=0;i--){
			for(int j=0;j<9;j++){
				if((i<=j)&&(i+j)<9){
					System.out.print(" * ");
				}else{
					System.out.print("   ");
				}
			}
			System.out.println("");
		}
		
		for(int i=1;i<5;i++){
			for(int j=0;j<9;j++){
				if((i<=j)&&(i+j)<9){
					System.out.print(" * ");
				}else{
					System.out.print("   ");
				}
			}
			System.out.println("");
		}
	}

}
