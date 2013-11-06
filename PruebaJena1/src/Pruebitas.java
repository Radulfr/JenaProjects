

import java.io.InputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.VCARD;
import com.hp.hpl.jena.vocabulary.RDF;

public class Pruebitas extends Object {

	// some definitions
	static String personURI    = "http://somewhere/JohnSmith";
	static String fullName     = "John Smith";

	public static void main (String args[]) {
		Model m = ModelFactory.createDefaultModel();
		
		// Indicamos el modelo
		Resource js = m.createResource(personURI)
				.addProperty(VCARD.N, fullName)
				.addProperty(VCARD.N,
						m.createResource()
						.addProperty(VCARD.Given, "John")
						.addProperty(VCARD.Family, "Smith"));

		// Listamos el modelo en función de las declaraciones
		
		StmtIterator iter = m.listStatements();
		Statement stmt; 
		
		Resource subject; 
		Property prop; 
		Object obj; 
		
		while (iter.hasNext()){
			stmt = iter.nextStatement();
			subject = stmt.getSubject();
			prop = stmt.getPredicate(); 
			obj = stmt.getObject();
			
			System.out.print("((" + subject.toString() +")) ----- " + prop.toString() +" ---- > " );
			if (obj instanceof Resource)
				System.out.print("(("+obj.toString()+"))");
			else
				System.out.print("["+obj.toString()+"]");
			
			System.out.println(".");
		}
		
	//	m.write(System.out, "N-TRIPLES") ;
		//*************************************************************************//
		// Leemos un documento desde un enlace web
		
		InputStream in = FileManager.get().open("vc-db-1.rdf.n3");
		
		if(in==null)
			throw new IllegalArgumentException("File not found"); 
		
		// leemos al modelo
		m.read(in, null, "N3");

		// escribmos
		m.write(System.out, "N-TRIPLES"); 
	}
}