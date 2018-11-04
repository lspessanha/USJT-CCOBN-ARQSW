package exercicio9_2;

public class Handler implements HandlerChain {
	
	HandlerChain nextChain;
	long timeLastRequest;
	int num;
	boolean busy;
	
	public Handler(int num) {
		this.num = num;
		this.timeLastRequest = 0;
		this.busy = false;
	}

	@Override
	public void setNextChain(HandlerChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void handleRequest(int request) {
		
		if (this.timeLastRequest == 0) this.timeLastRequest = System.currentTimeMillis();
		
		if (System.currentTimeMillis() - this.timeLastRequest > 200 && this.busy) this.busy = false;				
		
		if (!this.busy) {
			System.out.println("Request '" + request + "' atendida no handler " + this.num + ".");
			this.timeLastRequest = System.currentTimeMillis();
			this.busy = true;
		} else {
			if (nextChain != null) nextChain.handleRequest(request);
			else System.out.println("Tempo limite esgotado: request cancelado.");
		}
	}

}
