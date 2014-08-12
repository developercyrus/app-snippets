package snippets.xml.database.basex.a2;

import org.basex.core.BaseXException;
import org.basex.core.Context;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.DropDB;
import org.basex.core.cmd.XQuery;

/**
 * This class demonstrates collection relevant queries.
 * It shows how to find and query specific documents.
 *
 * @author BaseX Team 2005-14, BSD License
 */
public final class QueryCollection {
    /**
     * Runs the example code.
     * @param args (ignored) command-line arguments
     * @throws BaseXException if a database command fails
     */
    public static void main(final String[] args) throws BaseXException {
        // Database context.
        Context context = new Context();

        System.out.println("=== QueryCollection ===");

        // ------------------------------------------------------------------------
        // Create a collection from all XML documents in the specified directory
        System.out.println("\n* Create a collection.");

        new CreateDB("Collection", "src/main/resources/snippets/xml/database/basex/a2").execute(context);

        // ------------------------------------------------------------------------
        // List all documents in the database
        System.out.println("\n* List all documents in the database:");

        // The XQuery base-uri() function returns a file path
        System.out.println(new XQuery(
                            "for $doc in collection('Collection')" +
                                "return <doc path='{ base-uri($doc) }'/>"
        ).execute(context));

        // ------------------------------------------------------------------------
        // Evaluate a query on a single document
        System.out.println("\n* Evaluate a query on a single document:");

        // If the name of the database is omitted in the collection() function,
        // the currently opened database will be referenced
        System.out.println(new XQuery(
                "for $doc in collection()" +
                        "let $file-path := base-uri($doc)" +
                        "where ends-with($file-path, 'factbook.xml')" +
                        "return concat($file-path, ' has ', count($doc//*), ' elements')"
                ).execute(context));

        // ------------------------------------------------------------------------
        // Drop the database
        System.out.println("\n* Drop the database.");

        new DropDB("Collection").execute(context);

        // ------------------------------------------------------------------------
        // Close the database context
        context.close();
    }
}