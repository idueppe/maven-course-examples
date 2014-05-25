<html>
<body>
	<h2>Simple weather app</h2>

	Enter the ZIP code to get the current weather conditions:
	<form action="weather" method="get">
		<table border="0" cellpadding="5" cellspacing="0" bgcolor="#E0E0E0">
			<tr>
				<td align="right">ZIP code:</td>
				<td><input name="zip" type="text" size="5" maxlength=5
					value="11201">
				</td>
			</tr>
			<tr>
				<td align="right">Formular:</td>
				<td><input type="submit" value="Send"> <input
					type="reset" value="Reset"></td>
			</tr>
		</table>
	</form>

</body>
</html>
