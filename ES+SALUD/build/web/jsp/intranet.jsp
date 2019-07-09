
<%@page import="modelo.vo.Usuario"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/hospital.png"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilo.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
     

        <title>Es+Salud</title>
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
            <c:if test="${(bUsuario.ID_PERFIL == 1) || (bUsuario.ID_PERFIL == 2)}">
                <div class="row">
                    <div class="col-md-4">
                        <form class="" method="POST" action="Listar">
                         <input type="hidden" name="accion" value="goRegistrar">
                          <button class="btn btn-outline-primary  text-center  btn-block" type="submit" value="Registrar Usuario.">    
                              <p class=" font-weight-bold">INSERTAR</p><hr>
                          </button>
                        </form><br>
                    </div>
                    <div class="col-md-4">
                        <form class="" method="POST" action="Listar">
                            <input type="hidden" name="accion" value="goListar">
                            <button class="btn btn-outline-info text-center btn-block" type="submit" value="Listar Usuario.">    
                                <p class="font-weight-bold">LISTAR</p><hr>
                            </button>
                     </form><br>
                    </div>  
                    <div class="col-md-4">
                    <form class="" method="POST" action="Mantenimiento">
                        <input type="hidden" name="accion" value="goMantenimiento">
                        <button class="btn btn-outline-success  text-center  btn-block" type="submit" value="Mantenimiento.">    
                            <p class="font-weight-bold">MANTENIMIENTO</p><hr>
                        </button>
                    </form><br>
                    </div>
                </div>
            </c:if>
            <c:if test="${(bUsuario.ID_PERFIL == 3)}">
                <h4>Reporte de citas</h4>
                <table class="table table-bordered table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th>CODCITAS</th>
                            <th>HI_NDOCUM</th>
                            <th>HI_NOMBRE</th>
                            <th>ID_MEDICO</th>
                            <th>NOM_MEDICO</th>
                            <th>ESPE_MEDICO</th>
                            <th>FECHA</th>
                            <th>VISIBLE</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${alCitasDes}" var="cita">
                            <tr>
                                <td><c:out value="${cita.CODCITAS}"/></td>
                                <td><c:out value="${cita.HI_NDOCUM}"/></td>
                                <td><c:out value="${cita.HI_NOMBRE}"/></td>
                                <td><c:out value="${cita.ID_MEDICO}"/></td>
                                <td><c:out value="${cita.NOM_MEDICO}"/></td>
                                <td><c:out value="${cita.ESPE_MEDICO}"/></td>
                                <td><c:out value="${cita.FECHA}"/></td>
                                <td><c:out value="${cita.VISIBLE}"/></td>
                            </tr>               
                        </c:forEach> 
                    </tbody>
                </table>
            </c:if>}
                        <br><a  href="Intranet" class="btn btn-outline-danger">Regresar al menu Principal</a> 
        </div>

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
    <!-- ./Footer -->
</body>
</html>
