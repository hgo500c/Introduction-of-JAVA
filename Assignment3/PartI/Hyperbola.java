
public class Hyperbola {
	private static int nextId =1;
	private int id;
	private double vertex =1.0;
	private double covertex= 1.0;
	public Hyperbola(){
        this.id = Hyperbola.nextId;
        Hyperbola.nextId++;
    }

	public Hyperbola(double vertex,double covertex){
		this();
		this.covertex=covertex;
		this.vertex= vertex;
	}
	public double getVertex() {
		return this.vertex;
	}
	public void setVertex(double vertex) {
		this.vertex = vertex;
	}
	public double getCovertex() {
		return this.covertex;
	}
	public void setCovertex(double covertex) {
		this.covertex = covertex;
	}
	public double getFocusSquared() {
		return Math.pow(vertex,2) + Math.pow(covertex, 2);
	}
	public double getId() {
		return this.id;
	}
	 public static void main(String[] args) {
		    Hyperbola test = new Hyperbola();
		    test.setVertex(2.0);
		    test.setCovertex(6.0);
	        System.out.println("the vertex of test is " + test.getVertex() +
	                        ". the covertext of test2  is " + test.getCovertex() +
	                        ". test's focus squared is " + test.getFocusSquared()+
	                         ". the id is " + test.getId() );
           
	       Hyperbola test2 = new Hyperbola(2,3);
	       System.out.println("the vertex of test2 is " + test2.getVertex() +
                   ". the covertext of test2  is " + test2.getCovertex() +
                   ". test2's focus squared is " + test2.getFocusSquared()+
                    ". the id of test2 is " + test2.getId() );
	       test2.setVertex(10.0);
		    test2.setCovertex(8.0);
		    System.out.println("the vertex of test2 is " + test2.getVertex() +
	                   ". the covertext of test2  is " + test2.getCovertex() +
	                   ". test2's focus squared is " + test2.getFocusSquared()+
	                    ". the id of test2 is " + test2.getId() );
		    Hyperbola test3 = new Hyperbola(6,5);
		    System.out.println(
	                    ". the id of test3 is " + test3.getId() );
		    
	 }
}
