class CelulaCliente {

		Cliente item;
		CelulaCliente proximo;
		
		public CelulaCliente(Cliente cli) {
			
			item = cli;
			proximo = null;
		}
}