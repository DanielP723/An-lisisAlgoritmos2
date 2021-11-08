import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {

	static final int MAX = 1005;

	static int padre[] = new int[ MAX ]; 

	static void MakeSet( int n ){
	    for( int i = 1 ; i <= n ; ++i ) padre[ i ] = i;
	}

	static int Find( int x ){
	    return ( x == padre[ x ] ) ? x : ( padre[ x ] = Find( padre[ x ] ) );
	}

	static void Union( int x , int y ){
	    padre[ Find( x ) ] = Find( y );
	}

	static boolean sameComponent( int x , int y ){
	    if( Find( x ) == Find( y ) ) return true;
	    return false;
	}
        
	static int V , E;
	static class Edge implements Comparator<Edge>{
	    int origen;
	    int destino;
	    int peso;
	    Edge(){}
            
		@Override
		public int compare(Edge e1 , Edge e2 ) {
			return e1.peso - e2.peso;
		}
	};
	
	static Edge arista[] = new Edge[ MAX ];
	static Edge MST[] = new Edge[ MAX ];

	static void KruskalMST(){
	    int origen , destino , peso;
	    int total = 0;
	    int numAristas = 0;
	    
	    MakeSet( V );
	    Arrays.sort( arista , 0 , E , new Edge() );

	    for( int i = 0 ; i < E ; ++i ){
	        origen = arista[ i ].origen;
	        destino = arista[ i ].destino;
	        peso = arista[ i ].peso;

	        if( !sameComponent( origen , destino ) ){
	            total += peso;
	            MST[ numAristas++ ] = arista[ i ];
	            Union( origen , destino );
	        }
	    }
            
	    if( V - 1 != numAristas ){
	        System.out.println("No existe MST valido para el grafo ingresado, el grafo debe ser conexo.");
	        return;
	    }
	    System.out.println( "-----El MST encontrado contiene las siguientes aristas-----");
	    for( int i = 0 ; i < numAristas ; ++i )
	        System.out.printf("( %d , %d ) : %d\n" , MST[ i ].origen , MST[ i ].destino , MST[ i ].peso ); 
            
	    System.out.printf( "El costo minimo de todas las aristas del MST es : %d\n" , total );
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner( System.in );
		V = sc.nextInt(); E = sc.nextInt();
                
	    for( int i = 0 ; i < E ; ++i ){
	        arista[ i ] = new Edge();
	    	arista[ i ].origen = sc.nextInt();
	        arista[ i ].destino = sc.nextInt();
	        arista[ i ].peso = sc.nextInt();
                
	    }
	    KruskalMST();
	}
}