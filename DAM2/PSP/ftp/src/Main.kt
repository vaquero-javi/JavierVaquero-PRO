import org.apache.commons.net.ftp.FTP
import org.apache.commons.net.ftp.FTPClient
import java.io.FileInputStream
import java.io.FileOutputStream

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val ftp = FTPClient()
    try{
        ftp.connect("127.0.0.1", 21)
        ftp.login("dam2026", "1234")
        ftp.enterLocalPassiveMode()
        ftp.setFileType(FTP.BINARY_FILE_TYPE)

       val output = FileOutputStream("C:\\Users\\javie\\OneDrive\\Escritorio\\prueba\\fichero.txt")
        ftp.retrieveFile("/carpeta/javi2.json", output)
        output.close()
    }catch (e: Exception){
        e.printStackTrace()
    }finally {
        ftp.logout()
        ftp.disconnect()
    }
}