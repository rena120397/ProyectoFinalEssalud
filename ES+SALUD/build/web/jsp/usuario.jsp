<%@page import="modelo.perfil"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core">
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Es+Salud</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/hospital.png"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilo.css">  
        <link rel="stylesheet" href="//cdn.jsdelivr.net/chartist.js/latest/chartist.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.2/raphael-min.js"></script>
        <script src="//cdn.jsdelivr.net/chartist.js/latest/chartist.min.js"></script>
        <script src="js/morris.js"></script>
        <script src="js/es.js"></script>
    </head>
    <body>
        <div class="jumbotron jumbotron-fluid img-responsive text-center text-white jumbo">
                <h1 class="font-weight-bold">ES+SALUD</h1> 
                <h4>Confiabilidad, Seguridad y rapidez</h4> 
        </div>

        
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark d-flex">
  <!-- Brand -->
            <div class="container">      

  <!-- Links -->
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav">
                        <li class="bien"><span class="text-white font-weight-bold bien">Bienvenido </span></li>
                        <li><span class="men"><c:out value=" ${sessionScope.perse.nombre} "/></span></li>
                    </ul>
                    <ul class="navbar-nav ml-auto">                                 
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/servletsalud?eleccion=u5" class="btn btn-danger btn-block font-weight-bold pad"><i class="fas fa-sign-in-alt"></i> Cerrar Sesión</a>   
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
                        
            <div class="container"> <br>
                <div class="row">
                    <div class="col-lg-6">
                        <h2>INDICADOR DE RIESGO:</h2><br>
                        <p>Aquí se muestra la probabilidad que usted tiene de empeorar su enfermedad.</p><br>
                        <div class="card" id="grafo" style="height: 100%; width: 100%">
                        <div class="card-body" >                   
                            <script type="text/javascript">      
                                
                                var dom = document.getElementById("grafo");
                                var myChart = echarts.init(dom);
                                var app = {};
                                  option = null;
                                  option = {
                                  	tooltip : {
                                  		formatter: "{a} <br/>{b} : {c}%"
                                  	},
                                  	toolbox: {
                                  		feature: {
                                  			restore: {},
                                  			saveAsImage: {}
                                  		}
                                  	},
                                  	series: [
                                  		{
                                  			name: 'Su probabilidad de riesgo es de: ',
                                  			type: 'gauge',
                                  			detail: {formatter:'{value}%'},
                                  			data: [{value: <c:out value=" ${sessionScope.perse.pad.p} "/>, name: 'Riesgo'}]
                          			}
                          		]
                                  };
                          	if (option && typeof option === "object") {
                          		myChart.setOption(option, true);
                          	}
                           </script>
                  
                        </div>
                        </div>
                   </div>
                   <div class="col-lg-6">
                       <h2>ENFERMEDADES MÁS FRECUENTES:</h2><br>
                       <p>Aquí se muestran las el porcentaje de pacientes con las distintas enfermedades.</p><br>
                       <div class="card" style="height: 100%; ">
                          
                           <div class="card-body" >                   
                                
                                <div id="graph" style= "width: 100%; height: 100%"></div>
                                <script type="text/javascript">
                                    
                                    
                                     Morris.Donut({
                                          element: 'graph',
                                          data: [
                                            {value: <c:out value="${listadona[0]}"/>, label: 'Hipertensión', formatted: 'at least <c:out value="${listadona[0]}"/>%' },
                                            {value: <c:out value="${listadona[1]}"/>, label: 'Asma', formatted: 'approx. <c:out value="${listadona[1]}"/>%' },
                                            {value: <c:out value="${listadona[2]}"/>, label: 'Diabetes', formatted: 'approx. <c:out value="${listadona[2]}"/>%' },
                                            {value: <c:out value="${listadona[3]}"/>, label: 'Tuberculosis', formatted: 'at most <c:out value="${listadona[3]}"/>%' }
                                          ],
                                       formatter: function (x, data) { return data.formatted; }
                                       });
                                        </script>
                            </div>
                        </div>
                   </div>
            </div>
        </div>
        
        <div class="container"> <br>
            <div class="row">
                <div class="col-lg-6">
                    <h2>RESUMEN ESTADÍSTICO POR EDAD:</h2><br>
                    <p>Esta tabla muestra un resumen estadístico de la cantidad de pacientes con cierta enfermedad por edad.</p><br>
                    <div class="card" style="height: 80%; " ><br>
                <div class="ct-chart ct-perfect-fourth" style="height: 70%; font-size: 20px">
                    <script type="text/javascript">
                        
                    var data = {
                        labels: [<c:out value="${listatortanombres[0]}" escapeXml="false"/>],
                        series: [<c:out value="${listatorta[0]}"/>]
                      };
                      
                      var options = {
                        labelInterpolationFnc: function(value) {
                          return value[0]
                        }
                      };

                      var responsiveOptions = [
                        ['screen and (min-width: 300px)', {
                          chartPadding: 30,
                          labelOffset: 100,
                          labelDirection: 'explode',
                          labelColor: 'red',
                          labelInterpolationFnc: function(value) {
                            return value;
                          }
                        }],
                        ['screen and (min-width: 1024px)', {
                          labelOffset: 80,
                          chartPadding: 20,
                          labelColor: 'red'
                        }]
                      ];

                      new Chartist.Pie('.ct-chart', data, options, responsiveOptions);

                   </script>
                  
                </div>
            </div>
            </div>
            <div class="col-lg-6">
                <h2>RESUMEN ESTADÍSTICO POR EDAD:</h2><br>
                    <p>Esta tabla muestra un resumen estadístico de la cantidad de pacientes con cierta enfermedad por edad.</p><br>
            <div class="card" style="height: 80%; ">
              <div class="card-body" >                   
                    
                    <div id="graf" style= "width: 100%; height: 60%"></div>
                    <script type="text/javascript">
                    var day_data = [
                        {"period": "12-20 años", "Asma": <c:out value="${listabarra[0]}"/>,"Diabetes": <c:out value="${listabarra[1]}"/>,"Hipertensión":<c:out value="${listabarra[2]}"/>, "Tuberculosis": <c:out value="${listabarra[3]}"/>},
                        {"period": "21-30 años", "Asma": <c:out value="${listabarra[4]}"/>,"Diabetes": <c:out value="${listabarra[5]}"/>,"Hipertensión":<c:out value="${listabarra[6]}"/>, "Tuberculosis": <c:out value="${listabarra[7]}"/>},
                        {"period": "31-40 años", "Asma": <c:out value="${listabarra[8]}"/>,"Diabetes": <c:out value="${listabarra[9]}"/>,"Hipertensión":<c:out value="${listabarra[10]}"/>, "Tuberculosis": <c:out value="${listabarra[11]}"/>},
                        {"period": "41-50 años", "Asma": <c:out value="${listabarra[12]}"/>,"Diabetes": <c:out value="${listabarra[13]}"/>,"Hipertensión":<c:out value="${listabarra[14]}"/>, "Tuberculosis": <c:out value="${listabarra[15]}"/>},
                        {"period": "51-60 años", "Asma": <c:out value="${listabarra[16]}"/>,"Diabetes": <c:out value="${listabarra[17]}"/>,"Hipertensión":<c:out value="${listabarra[18]}"/>, "Tuberculosis": <c:out value="${listabarra[19]}"/>},
                        {"period": "61-70 años", "Asma": <c:out value="${listabarra[20]}"/>,"Diabetes": <c:out value="${listabarra[21]}"/>,"Hipertensión":<c:out value="${listabarra[22]}"/>, "Tuberculosis": <c:out value="${listabarra[23]}"/>},
                        {"period": "71-80 años", "Asma": <c:out value="${listabarra[24]}"/>,"Diabetes": <c:out value="${listabarra[25]}"/>,"Hipertensión":<c:out value="${listabarra[26]}"/>, "Tuberculosis": <c:out value="${listabarra[27]}"/>},
                        {"period": "81-90 años", "Asma": <c:out value="${listabarra[28]}"/>,"Diabetes": <c:out value="${listabarra[29]}"/>,"Hipertensión":<c:out value="${listabarra[30]}"/>, "Tuberculosis": <c:out value="${listabarra[31]}"/>},
                        {"period": "91-100 años", "Asma": <c:out value="${listabarra[32]}"/>,"Diabetes": <c:out value="${listabarra[33]}"/>,"Hipertensión":<c:out value="${listabarra[34]}"/>, "Tuberculosis": <c:out value="${listabarra[35]}"/>}
                      ];
                      Morris.Bar({
                        element: 'graf',
                        data: day_data,
                        xkey: 'period',
                        ykeys: ['Asma', 'Diabetes', 'Hipertensión', 'Tuberculosis'],
                        labels: ['Asma', 'Diabetes', 'Hipertensión', 'Tuberculosis'],
                        xLabelAngle: 60
                      });     
                    </script>
              </div>
            </div>          
            </div>          
        </div>
        </div>
                     
                        
        <div class="container padd">
          
            <div class="row text-center">
                <div class="col-lg-3">
                    <a href="${pageContext.request.contextPath}/servletsalud?eleccion=u1" class="btn btn-outline-success btn-block bt">                 
                            <p class="font-weight-bold">PERFIL DEL USUARIO</p><hr>
                    </a>
                </div>        
                        
                <div class="col-lg-3">
                    <a href="${pageContext.request.contextPath}/servletsalud?eleccion=u2" class="btn btn-outline-info text-center btn-block bt">       
                            <p class="font-weight-bold">GENERAR CITA</p><hr>     
                    </a>
                </div> 
                        
                <div class="col-lg-3">
                    <a href="${pageContext.request.contextPath}/servletsalud?eleccion=u3" class="btn btn-outline-primary  text-center  btn-block bt">        
                            <p class="font-weight-bold text-center">DOCTORES DISPONIBLES</p><hr>
                    </a>
                </div>
                
                <div class="col-lg-3">
                    <a href="${pageContext.request.contextPath}/servletsalud?eleccion=u4" class="btn btn-outline-warning text-center btn-block bt">    
                            <p class="font-weight-bold ">HISTORIAL DE CITAS</p><hr>
                    </a>
                </div>
                            
            </div><br>
        </div>  
        <!-- Footer -->
	<section id="footer">
		<div class="container">
			<div class="row text-center text-xs-center">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<h5>Enlaces Empresariales Internos</h5>
					<ul class="list-unstyled quick-links">
						<li><a href="../index.html"><i class="fa fa-angle-double-right"></i>Inicio</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>About</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Videos</a></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<h5>Enlaces Empresariales Externos</h5>
					<ul class="list-unstyled quick-links">
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Inicio</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>About</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Videos</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-5">
					<ul class="list-unstyled list-inline social text-center">
						<li class="list-inline-item"><a href="https://www.facebook.com/EsSaludPeruOficial/" target="_blank"><i class="fab fa-facebook-f"></i></a></li>
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
        <div class="modal fade" id="mostrarmodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content text-center">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Notificaciones: </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <c:out value=" ${sessionScope.perse.nombre} "/> Usted se encuentra dentro del <span class="textorojo font-weight-bold"><c:out value=" ${sessionScope.perse.pad.p} "/> % </span> que padece <span class="textorojo font-weight-bold"> <c:out value=" ${sessionScope.perse.pad.nompadecencia} "/> </span></br>
         <span class="textorojo font-weight-bold">Riesgos: </span></br>
                <c:forEach items="${lista}" var="l">
                    <c:out value="${l}" escapeXml="false"/>
                </c:forEach>
      </div>
      <div class="modal-footer">
          <a href="${pageContext.request.contextPath}/servletsalud?eleccion=u2" class="btn btn-outline-success">  
              <p class="font-weight-bold">GENERAR CITA</p> 
          </a>
        <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Cerrar </button>
      </div>
    </div>
  </div>
</div>
</div>
        <script>
       
            $(document).ready(function()
            {
               $("#mostrarmodal").modal("show");
            });
           
  
        </script>
        <script>
            
            
            
            
        </script>
        
    </body>
    
</html>