package modelo;
public class dona {
   private String nome;
   private Double proben;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getProben() {
        return proben;
    }

    public void setProben(Double proben) {
        this.proben = proben;
    }
}
/*
MORRIS

<c:forEach items="${listadona}" var="d">
<c:choose>
<c:when test="${not empty d.nome}">
    {value: <c:out value="${d.proben}" />, label: <c:out value="${d.nome}" />, formatted: 'at least <c:out value="${d.proben}" />%' },
</c:when>
</c:choose>
</c:forEach>
  ],
formatter: function (x, data) { return data.formatted; }
});

*/