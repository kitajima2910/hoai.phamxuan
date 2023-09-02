using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

using WebSocketSharp;
using WebSocketSharp.Server;


namespace WebSocket_Server
{

    public class Echo : WebSocketBehavior
    {
        protected override void OnMessage(MessageEventArgs e)
        {
            Console.WriteLine("Received message from Echo client: " + e.Data);
            Send(e.Data);
        }
    }

    public class EchoAll : WebSocketBehavior
    {
        protected override void OnMessage(MessageEventArgs e)
        {
            Console.WriteLine("Received message from EchoAll client: " + e.Data);
            Sessions.Broadcast(e.Data);
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            WebSocketServer wssw = new WebSocketServer("ws://192.168.0.104:2910");

            wssw.AddWebSocketService<Echo>("/Echo");
            wssw.AddWebSocketService<Echo>("/EchoAll");


            wssw.Start();
            Console.WriteLine("WS Server started on ws://192.168.0.104:2910/Echo");
            Console.WriteLine("WS Server started on ws://192.168.0.104:2910/EchoALL");


            Console.ReadKey();
            wssw.Stop();
        }
    }
}
