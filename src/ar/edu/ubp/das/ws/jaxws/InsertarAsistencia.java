
package ar.edu.ubp.das.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.3.3
 * Sat Jun 20 14:05:18 ART 2020
 * Generated source version: 3.3.3
 */

@XmlRootElement(name = "insertarAsistencia", namespace = "http://ws.das.ubp.edu.ar/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarAsistencia", namespace = "http://ws.das.ubp.edu.ar/")

public class InsertarAsistencia {

    @XmlElement(name = "arg0")
    private ar.edu.ubp.das.bean.AsistenciaBean arg0;

    public ar.edu.ubp.das.bean.AsistenciaBean getArg0() {
        return this.arg0;
    }

    public void setArg0(ar.edu.ubp.das.bean.AsistenciaBean newArg0)  {
        this.arg0 = newArg0;
    }

}

