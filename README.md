# SISRH

- para rodar no WINDOWS é necessário alterar o método `criarConexaoBanco()`, na classe `Banco` para algo assim:

```	
static private void criarConexaoBanco() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:hsqldb:file:/home/evandro/Desenvolvimento/backend//sisrh_db//rh_db",
					"SA", "");
			System.out.println("Conexão ao banco BANCO_SISRH.........[OK]");
		} catch (SQLException e) {
			System.out.println("Conexão ao banco BANCO_SISRH.........[NOK]");
			if (e.getMessage().contains("lockFile")) {
				JOptionPane.showMessageDialog(null,
						"O banco est� bloqueado \n porque o Tomcat não liberou a conexão. REINICIE O TOMCAT");

			} else {
				e.printStackTrace();
			}
		}
	}
