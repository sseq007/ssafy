<?xml version='1.0' encoding='euc-kr'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" encoding='euc-kr'/> 

<xsl:template match="/">
<html>
  <head><TITLE>�ּҷ�xsl</TITLE> </head>
  <body>
	<table border='1'>
	<tr><td>�̸�</td>
	<td>��ȣ</td>
	<td>email</td>
	<td>�޴���ȭ</td></tr>
	<xsl:apply-templates select="�ּҷ�/����"/>
	</table>
  </body>
</html>
</xsl:template> 

<xsl:template match="����">
	<tr>
		<td><xsl:value-of select="�̸�" /></td>
		<td><xsl:value-of select="@�ֹι�ȣ" /></td>
		<td><xsl:value-of select="email" /></td>
		<td><xsl:copy-of select="�޴���ȭ" /></td>
	</tr>
</xsl:template> 

</xsl:stylesheet>