<%@page import="modelo.vo.Usuario"%>
<%@page import="modelo.doctor"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Es+Salud</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/hospital.png"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilo.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">

    </head>
    <body>
        <div class="jumbotron jumbotron-fluid img-responsive text-center text-white jumbo">
            <h1 class="font-weight-bold">ES+SALUD</h1> 
            <h4>Confiabilidad, Seguridad y rapidez</h4> 
        </div>
        
        
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark d-flex">
  <!-- Brand -->
            <div class="container">
            <a class="navbar-brand text-white font-weight-bold" href="#">Bienvenido  <c:out value="${sessionScope.bUsuario.NOMBRE}"/></a>

  <!-- Links -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="Salir" class="btn btn-danger btn-block font-weight-bold"><i class="fas fa-sign-in-alt"></i> Cerrar Sesión</a>   
                </li>
            </ul>
            </div>
            </div>
        </nav><br><br>
        
        
        <div class="container">
            <h2>Insertar </h2><hr>
            <h4>Reporte</h4>
            <div class="table-responsive" style="height: 20rem;">
                <table class="table table-bordered table-hover">
                    <thead class="thead-dark">
                        <c:if test="${(accion eq 'goRegistrarAdm') || (accion eq 'Insertar')}">
                            <c:if test="${(bUsuario.ID_PERFIL == 1)}">
                                <tr>
                                    <th>ID_USU</th>
                                    <th>Nombre</th>
                                    <th>Contraseña</th>
                                    <th>ID_PERFIL</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${alUsuarios}" var="usuario">
                                    <tr>
                                        <td><c:out value="${usuario.ID_USU}"/></td>
                                        <td><c:out value="${usuario.NOMBRE}"/></td>
                                        <td><c:out value="${usuario.CONTRA}"/></td>
                                        <td><c:out value="${usuario.ID_PERFIL}"/></td>
                                    </tr>               
                                </c:forEach> 
                            </tbody>
                        </table>
                    </c:if>
                </c:if>
                <c:if test="${(accion eq 'goRegistrarMedicos') || (accion eq 'InsertarMedico')}">
                    <c:if test="${(bUsuario.ID_PERFIL == 1) || (bUsuario.ID_PERFIL == 2)}">
                        <tr>
                            <th>ID_MEDICO</th>
                            <th>Nombre</th>
                            <th>ESPECIALIDAD</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listamedico}" var="d">
                                <tr>
                                    <td><c:out value="${d.idoctor}"/></td>
                                    <td><c:out value="${d.nombred}"/></td>
                                    <td><c:out value="${d.especialidad}"/></td>
                                </tr>               
                            </c:forEach> 
                        </tbody>
                        </table>
                    </c:if>
                </c:if>
                <c:if test="${(accion eq 'goRegistrarPacientes') || (accion eq 'InsertarPaciente')}">
                    <c:if test="${(bUsuario.ID_PERFIL == 1) || (bUsuario.ID_PERFIL == 2)}">
                        <tr>
                            <th>HI_NREG</th>
                            <th>HI_NOMBRE</th>
                            <th>HI_FECNAC</th>
                            <th>HI_DIRECC</th>
                            <th>HI_SEXO</th>
                            <th>HI_FULTAT</th>
                            <th>HI_NDOCUM</th>
                            <th>HI_ESTCIV</th>
                            <th>HI_CONTRA</th>
                            <th>HI_PAD</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listapaciente}" var="p">
                                <tr>
                                    <td><c:out value="${p.HI_NREG}"/></td>
                                    <td><c:out value="${p.HI_NOMBRE}"/></td>
                                    <td><c:out value="${p.HI_FECNAC}"/></td>
                                    <td><c:out value="${p.HI_DIRECC}"/></td>
                                    <td><c:out value="${p.HI_SEXO}"/></td>
                                    <td><c:out value="${p.HI_FULTAT}"/></td>
                                    <td><c:out value="${p.HI_NDOCUM}"/></td>
                                    <td><c:out value="${p.HI_ESTCIV}"/></td>
                                    <td><c:out value="${p.HI_CONTRA}"/></td>
                                    <td><c:out value="${p.HI_PAD}"/></td>
                                </tr>               
                            </c:forEach> 
                        </tbody>
                        </table>
                    </c:if>
                </c:if>

            </div><hr>
            <br>
            <c:if test="${(accion eq 'goRegistrarAdm') || (accion eq 'Insertar')}">
                <c:if test="${(bUsuario.ID_PERFIL == 1)}">
                    <form method="POST" action="Insertar">
                        <div class="form-group">
                            <label for="nombre">Id_Usu</label>
                            <input type="text" name="TXT_ID_USU" class="form-control" id="nombre" required placeholder="Ingrese ID_USU">
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre:</label>
                            <input type="text" name="TXT_NOMBRE" class="form-control" id="nombre" required placeholder="Ingrese Nombre">
                        </div>
                        <div class="form-group">
                            <label for="nombre">Contra</label>
                            <input type="text" name="TXT_CONTRA" class="form-control" id="apellido" required placeholder="Ingrese Contraseña">
                        </div>
                        <div class="form-group">
                            <label for="nombre">Id_Perfil</label>
                            <input type="number" name="TXT_ID_PERFIL" class="form-control" id="usuario" required placeholder="Ingrese ID_PERFIL">
                        </div>
                        <input type="hidden" name="accion" value="Insertar">
                        <button type="submit" class="btn btn-success text-center">INSERTAR</button>
                        <button type="reset" class="btn btn-danger text-center">RESETEAR</button>
                        <br>
                    </form>
                </c:if>
            </c:if>
            <c:if test="${(accion eq 'goRegistrarMedicos') || (accion eq 'InsertarMedico')}">
                <c:if test="${(bUsuario.ID_PERFIL == 1) || (bUsuario.ID_PERFIL == 2)}">
                    <form method="POST" action="Insertar">
                        <div class="form-group">
                            <label for="nombre">ID_MEDICO</label>
                            <input type="text" name="idmedico" class="form-control" id="nombre" required placeholder="Ingrese ID_MEDICO">
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre:</label>
                            <input type="text" name="nombre" class="form-control" id="nombre" required placeholder="Ingrese Nombre:">
                        </div>
                        <div class="form-group">
                            <label for="nombre">Especialidad</label>
                            <input type="text" name="especialidad" class="form-control" id="apellido" required placeholder="Ingrese Especialidad">
                        </div>
                        <input type="hidden" name="accion" value="InsertarMedico">
                        <button type="submit" class="btn btn-success text-center">INSERTAR</button>
                        <button type="reset" class="btn btn-danger text-center">RESETEAR</button>
                        <br>
                    </form>
                </c:if>
            </c:if>
            <c:if test="${(accion eq 'goRegistrarPacientes') || (accion eq 'InsertarPaciente')}">
                <c:if test="${(bUsuario.ID_PERFIL == 1) || (bUsuario.ID_PERFIL == 2)}">
                    <form method="POST" action="Insertar">
                        <div class="form-group">
                            <label for="nombre">HI_NREG</label>
                            <input type="text" name="HI_NREG" class="form-control" id="nombre" required placeholder="Ingrese HI_NREG(char 5) EJM: 326">
                        </div>
                        
                        <div class="form-group">
                            <label for="nombre">HI_NOMBRE</label>
                            <input type="text" name="HI_NOMBRE" class="form-control" id="apellido" required placeholder="Ingrese HI_NOMBRE (varchar) nombre completo">
                        </div>
                        <div class="form-group">
                            <label for="nombre">HI_FECNAC</label>
                            <input type="text" name="HI_FECNAC" class="form-control" id="apellido" required placeholder="Ingrese HI_FECNAC (Date) EJM: 1943-11-24 00:00:00.000">
                        </div>
                        <div class="form-group">
                            <label for="nombre">HI_DIRECC</label>
                            <input type="text" name="HI_DIRECC" class="form-control" id="apellido" required placeholder="Ingrese HI_DIRECC (varchar)">
                        </div>
                        <div class="form-group">
                            <label for="nombre">HI_SEXO</label>
                            <input type="text" name="HI_AUTASE" class="form-control" id="nombre" required placeholder="Ingrese HI_SEXO(CHAR) M o F ">
                        </div>
                        <div class="form-group">
                            <label for="nombre">HI_FULTAT</label>
                            <input type="text" name="HI_FULTAT" class="form-control" id="apellido" required placeholder="Ingrese HI_FULTAT (Date) EJM: 1943-11-24 00:00:00.000">
                        </div>
                        <div class="form-group">
                            <label for="nombre">HI_NDOCUM</label>
                            <input type="text" name="HI_NDOCUM" class="form-control" id="apellido" required placeholder="Ingrese HI_NDOCUM (number) 8 digitos">
                        </div>
                        <div class="form-group">
                            <label for="nombre">HI_ESTCIV</label>
                            <input type="text" name="HI_ESTCIV" class="form-control" id="apellido" required placeholder="Ingrese HI_ESTCIV (char 1) EJM: S,C,V,D">
                        </div>
                        <div class="form-group">
                            <label for="nombre">HI_CONTRA</label>
                            <input type="text" name="HI_CONTRA" class="form-control" id="apellido" required placeholder="Ingrese HI_CONTRA (varchar) EJEM: 0123PUSE">
                        </div>
                        <div class="form-group">
                            <label for="nombre">HI_PAD</label>
                            <input type="text" name="HI_PAD" class="form-control" id="nombre" required placeholder="Ingrese HI_PAD (varchar) EJM: A01">
                        </div>
                        <input type="hidden" name="accion" value="InsertarPaciente">
                        <button type="submit" class="btn btn-success text-center">INSERTAR</button>
                        <button type="reset" class="btn btn-danger text-center">RESETEAR</button>
                        <br>
                    </form>
                </c:if>
            </c:if>
                        <br><a  href="Intranet" class="btn btn-outline-danger">Regresar al menu Principal</a>
        </div><hr>  
        <!-- Footer -->
        <section id="footer">
        <div class="container">
            <div class="row text-center text-xs-center">
                <div class="col-xs-12 col-sm-6 col-md-6">
                    <h5>Enlaces Empresariales Internos</h5>
                    <ul class="list-unstyled quick-links">
                        <li><a href="../index.html"><i class="fa fa-angle-double-right"></i>Inicio</a></li>
                        <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>About</a></li>
                        <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>FAQ</a></li>
                        <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Videos</a></li>
                    </ul>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-6">
                    <h5>Enlaces Empresariales Externos</h5>
                    <ul class="list-unstyled quick-links">
                        <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Inicio</a></li>
                        <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>About</a></li>
                        <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>FAQ</a></li>
                        <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Videos</a></li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-5">
                    <ul class="list-unstyled list-inline social text-center">
                        <li class="list-inline-item"><a href="https://www.facebook.com/EsSaludPeruOficial/" target="_blank"><i class="fab fa-facebook-square"></i></a></li>
                        <li class="list-inline-item"><a href="https://twitter.com/essaludperu?lang=es" target="_blank"><i class="fab fa-twitter"></i></a></li>
                        <li class="list-inline-item"><a href="https://www.instagram.com/essaludperu/" target="_blank"><i class="fab fa-instagram"></i></a></li>
                        <li class="list-inline-item"><a href="http://www.essalud.gob.pe/" target="_blank"><i class="fab fa-google-plus-g"></i></a></li>
                        <li class="list-inline-item"><a href="http://www.essalud.gob.pe/" target="_blank"><i class="fa fa-envelope"></i></a></li>
                    </ul>
                </div>
                </hr>
            </div>	
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">
                    <p>Propiedad de ES+SALUD CARABAYLLO</p>
                    <p class="h6">&copy All right Reversed. Grupo 5 Curso Integrador</p>
                </div>
                </hr>
            </div>	
        </div>
    </section>
    </body>
</html>
