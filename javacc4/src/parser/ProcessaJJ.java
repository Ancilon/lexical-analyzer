package javacc4.src.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class ProcessaJJ {
     
         
	public static void main(String args[]) {
            //CHAMANDO CMD E PASSANDO O ENDEREÇO DO ARQUIVO BAT QUE PROCESSA O JJ
            executar("cmd.exe", "/c", "c:\\analex\\src\\parser\\tt.bat");
            
            // "Manaus"
            
	}
        
        
 static   void executar(String scriptExec, String typeCommand, String command){
 
String[] finalCommand;
 
finalCommand = new String[3];
 
finalCommand[0] = scriptExec;
 
finalCommand[1] = typeCommand;
 
finalCommand[2] = command;
 
Process proc;
 
String sucesso = "", erro = "", escuta;
 
try{
 
proc = Runtime.getRuntime().exec(finalCommand);
 
proc.waitFor();
 
BufferedReader inputSucesso = new BufferedReader(new InputStreamReader(proc.getInputStream()));
 
BufferedReader inputErro = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
 
while ((escuta = inputSucesso.readLine()) != null) {
 
sucesso += escuta + "\n";
 
}
 
inputSucesso.close();
 
while ((escuta = inputErro.readLine()) != null) {
 
erro += escuta + "\n";
 
}
 
inputErro.close();
 
if(!sucesso.equals("")){
 
System.out.println("Sucesso!");
 
System.out.println(sucesso);
 
}else if(!erro.equals("")){
 
System.out.println("Erro!");
 
System.out.println(erro);
 
}
 
}catch (IOException ex) {
 
ex.printStackTrace();
 
}catch (InterruptedException ie){
 
ie.printStackTrace();
 
}
 
}
        
        
}

