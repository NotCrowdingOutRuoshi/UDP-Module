package Mock;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Timer;
import java.util.TimerTask;

import UDPModule.IUDPUS;
import UDPModule.Entity.SCommand;
import UDPModule.Factory.ServerActionFactory;

public class UDPUSMock implements IUDPUS {

	private int _port = 27016;;
	private int _bufferSize = 512;
	private byte _buffer[];

	private DatagramPacket _dataPacket;
	private DatagramSocket _socket;

	private String result = "";
	
	public UDPUSMock() {
		// TODO Auto-generated constructor stub
		_buffer = new byte[_bufferSize];
		_dataPacket = new DatagramPacket(_buffer, _buffer.length);
	}

	@Override
	public void initUDPserver() {

	}

	@Override
	public void stopUDPServer() {
		// TODO Auto-generated method stub
		if (_socket != null) {
			_socket.close();
		}
	}

	public void receiveData() {
		try {
			_socket = new DatagramSocket(_port);
			_socket.receive(_dataPacket);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = new String(_buffer, 0, _dataPacket.getLength());
		_socket.close();
	}
	
	public String getResult() {
		return result;
	}

}
