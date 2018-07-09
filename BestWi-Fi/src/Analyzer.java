import java.io.IOException;

import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.packet.Packet;
import org.pcap4j.packet.Packet.Header;
import org.pcap4j.util.NifSelector;
import org.pcap4j.*;
import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode;
import org.pcap4j.core.BpfProgram;
public class Analyzer {
	 public static void main(String[] args) throws IOException, NotOpenException, PcapNativeException
	 {
		 System.out.println("teste");
		 PcapNetworkInterface nif = null;
		 System.out.println("teste");
	         // Lista as interfaces
	            nif = new NifSelector().selectNetworkInterface();
	            if(nif == null)
	            {
	            	System.exit(1);
	            }
		 PcapHandle handler = nif.openLive(65536, PromiscuousMode.PROMISCUOUS, 10);
		 Packet pacote = null;
		 System.out.println("wololo");
		 handler.setFilter("tcp", BpfProgram.BpfCompileMode.OPTIMIZE);
		 while(pacote == null)
		 {
			 pacote = handler.getNextPacket();
		 }
		 Packet payload = null;
		 System.out.println("wololo2");
		 while(payload == null || payload.getRawData().length == 1 )
		 {
		      payload = pacote.getPayload();
		 }
		 Header cabecalho = pacote.getHeader();
		 //System.out.println(cabecalho.toString());
		 String nseq;
	     String seqtratamento;
	     String janela;
	     String jantratamento;
	     String payloadstring;
	     seqtratamento = payload.toString();
	     payloadstring = payload.toString();
	     System.out.println(payload);
	     seqtratamento = seqtratamento.substring(530, 550);
	     seqtratamento = seqtratamento.replaceAll("[^0-9]", "");
	     nseq = seqtratamento;
	     System.out.println(nseq);
	     //jantratamento = payload.toString();
	     //int valinicial = payloadstring.length() - 110;
	     //int valfinal = valinicial +30;
	     //jantratamento = jantratamento.substring(valinicial, valfinal);
	     //janela = jantratamento;
	     //System.out.println(janela);
	     //System.out.println(payloadstring.length());
	     //System.out.println(payload.getRawData().length);
	     String[] parts = payloadstring.split(":");
	     janela = parts[28];
	     janela = janela.replaceAll("[^0-9]", "");
	     System.out.println(janela);
	     //System.out.println(seqtratamento.substring(530, 550));
		 //System.out.println(payload);
	     //System.out.println(payload.toString());
         
        
		
		 
	 }

     
}

