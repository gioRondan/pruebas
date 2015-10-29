
package wsc;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estado.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="estado">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="registrada"/>
 *     &lt;enumeration value="cancelada"/>
 *     &lt;enumeration value="pagada"/>
 *     &lt;enumeration value="facturada"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "estado")
@XmlEnum
public enum Estado {

    @XmlEnumValue("registrada")
    REGISTRADA("registrada"),
    @XmlEnumValue("cancelada")
    CANCELADA("cancelada"),
    @XmlEnumValue("pagada")
    PAGADA("pagada"),
    @XmlEnumValue("facturada")
    FACTURADA("facturada");
    private final String value;

    Estado(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Estado fromValue(String v) {
        for (Estado c: Estado.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
