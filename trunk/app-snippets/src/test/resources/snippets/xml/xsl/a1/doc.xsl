<?xml version="1.0"?> 
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">  
<xsl:template match="resume"> 
    <html> 
        <body>  
            <table border="1">   
                <tr> 
                    <td>First Name</td>  
                    <td><xsl:value-of select="field1"/></td>                          
                </tr> 
                <tr> 
                    <td>Last Name</td>  
                    <td><xsl:value-of select="field2"/></td>                          
                </tr> 
            </table>     
        </body>
    </html> 
</xsl:template> 
</xsl:stylesheet>