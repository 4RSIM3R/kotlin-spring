package id.nexteam.kotlinspringhello.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "todos")
data class Todo(

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        val id: Long?,

        @Column(name = "task")
        var task: String,

        @Column(name = "created_at")
        @CreationTimestamp
        val createdAt: Date?,

        @Column(name = "updated_at")
        @UpdateTimestamp
        val updatedAt: Date?

)
