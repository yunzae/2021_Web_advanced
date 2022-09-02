<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" doctype-system="about:legacy-compat"/>
    <xsl:template match="/">
    <html>
        <head>

        </head>
 
        <body>
            
                <xsl:for-each select="/like">

                            <p><xsl:value-of select="icon"/>
                            [<xsl:value-of select="kind"/>] 
                            <a href="{link}"><xsl:value-of select="link"/></a>
                            (<xsl:value-of select="kind"/>)회 방문)
                            </p>
                          

                </xsl:for-each>
            
        </body>
    </html>
    </xsl:template>
</xsl:stylesheet>
