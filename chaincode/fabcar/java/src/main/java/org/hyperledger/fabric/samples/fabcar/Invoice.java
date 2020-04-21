/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.hyperledger.fabric.samples.fabcar;

import java.util.Objects;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import com.owlike.genson.annotation.JsonProperty;

@DataType()
public final class Invoice {

    @Property()
    private final String rechnungsnummer;
    
    @Property()
    private final Boolean empfangen;

    @Property()
    private final String color;

    @Property()
    private final String owner;


    public String getColor() {
        return color;
    }

    public String getOwner() {
        return owner;
    }
    
    public String getRechnungsnummer() {
        return rechnungsnummer;
    }

    public Boolean getEmpfangen() {
        return empfangen;
    }

    public Invoice(@JsonProperty("rechnungsnummer") final String rechnungsnummer, @JsonProperty("empfangen") final Boolean empfangen, @JsonProperty("color") final String color, @JsonProperty("owner") final String owner) {
        this.rechnungsnummer = rechnungsnummer;
        this.color = color;
        this.owner = owner;
        this.empfangen = empfangen;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        Invoice other = (Invoice) obj;

        return Objects.deepEquals(new String[] {getRechnungsnummer(), getEmpfangen() + "",  getColor(), getOwner()},
                new String[]                   {other.getRechnungsnummer(), other.getEmpfangen() + "", other.getColor(), other.getOwner()});
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRechnungsnummer(), getEmpfangen() + "", getColor(), getOwner());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " [rechnungsnummer=" + rechnungsnummer + ", empfangen="
                + empfangen + ", color=" + color + ", owner=" + owner + "]";
    }
}
