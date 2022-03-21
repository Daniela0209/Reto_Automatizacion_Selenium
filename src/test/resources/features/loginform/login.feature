Feature: Usuario Login
  Yo como usuario de la plataforma
  Deseo poder ingresar a mi cuenta
  Para poder interactuar y ver mi cuenta

  @Regresion
  Scenario: El usuario digita los en la pagina el usuario y contrasena validos
    Given que el usuario desea poder entrar a su cuenta
    When el usuario ingresa en la pagina el usuario y contrasena correctos
    Then Se muestra informacion de la cuenta

  @Regresion
  Scenario: El usuario digita el usuario invalido y contrasena valida
    Given que el usuario desea poder ingresar a su cuenta
    When el usuario ingresa en la pagina el usuario invalido y contrasena correcta
    Then Se muestra un mensaje de error en los datos ingresados
