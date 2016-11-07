package model;

import javax.persistence.*;

/**
 * Created by Дамир on 15.09.2016.
 */
@Entity
@Table(name = "provider", schema = "public", catalog = "pharmacy")
public class ProviderEntity {
    private int idProvider;
    private String providername;
    private Long providerphone;

    public ProviderEntity() {
    }

    public ProviderEntity(String providername, Long providerphone) {
        this.providername = providername;
        this.providerphone = providerphone;
    }

    public ProviderEntity(int idProvider, String providername, Long providerphone) {
        this.idProvider = idProvider;
        this.providername = providername;
        this.providerphone = providerphone;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_provider")
    public int getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }

    @Basic
    @Column(name = "providername")
    public String getProvidername() {
        return providername;
    }

    public void setProvidername(String providername) {
        this.providername = providername;
    }

    @Basic
    @Column(name = "providerphone")
    public Long getProviderphone() {
        return providerphone;
    }

    public void setProviderphone(Long providerphone) {
        this.providerphone = providerphone;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProviderEntity that = (ProviderEntity) o;

        if (idProvider != that.idProvider) return false;
        if (providername != that.providername) return false;
        if (providerphone != that.providerphone) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProvider;
        result = 31 * result + providername;
        result = 31 * result + providerphone;
        return result;
    }*/
}
