Feature: Usuario Login
  Yo como usuario de la plataforma
  Deseo poder ingresar a mi cuenta
  Para poder interactuar y ver mi cuenta

  @Regresion
  Scenario: El usuario digita los en la pagina el usuario y contrasena validos
    Given que el usuario desea poder entrar a su cuenta
    When el usuario ingresa en la pagina el usuario y contrasena correctos
    Then Se muestra informacion de la cuenta
