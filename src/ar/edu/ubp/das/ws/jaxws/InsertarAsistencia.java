
package ar.edu.ubp.das.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.3.3
 * Sun May 31 12:19:01 ART 2020
 * Generated source version: 3.3.3
 */

@XmlRootElement(name = "insertarAsistencia", namespace = "http://ws.das.ubp.edu.ar/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarAsistencia", namespace = "http://ws.das.ubp.edu.ar/")

public class InsertarAsistencia {

    @XmlElement(name = "asistencia")
    private ar.edu.ubp.das.bean.AsistenciaBean asistencia;

    public ar.edu.ubp.das.bean.AsistenciaBean getAsistencia() {
        return this.asistencia;
    }

    public void setAsistencia(ar.edu.ubp.das.bean.AsistenciaBean newAsistencia)  {
        this.asistencia = newAsistencia;
    }

}

