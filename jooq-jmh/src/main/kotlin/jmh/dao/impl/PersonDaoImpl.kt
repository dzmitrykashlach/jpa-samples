package jmh.dao.impl

import jmh.dao.PersonDao
import jmh.dao.PersonRowMapper
import jmh.entities.Person
import jmh.jooq.generated.jooq_jmh.tables.Person.PERSON
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.Result
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class PersonDaoImpl:PersonDao {
    lateinit var dslContext: DSLContext

    override fun findAll(): List<Person?>? {
        val records: Result<Record> = dslContext
            .select().from(PERSON).fetch()
        if (records == null) {
//            FIXME - what if table is empty ?
            return null
        }
        return PersonRowMapper().mapPersonRecords(records)
    }


    override fun findById(id: Int?): Person? {
        TODO("Not yet implemented")
    }

    override fun save(person: Person?) {
        TODO("Not yet implemented")
    }

    override fun delete(person: Person?) {
        TODO("Not yet implemented")
    }

    override fun findAllByAge(category: String?): List<Person?>? {
        TODO("Not yet implemented")
    }

    override fun findAllByCreatedAt(createdAt: LocalDateTime?): List<Person?>? {
        TODO("Not yet implemented")
    }
    /*
    private final DSLContext dslContext;

    public ActorDaoJOOQImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public List<Actor> findAll() {
        var records = this.dslContext
                .select().from(ACTOR).fetch();
        if(records==null){
            log.error("No records found in Actor table");
            return null;
        }
        return ActorRowMapper.mapActorRecord(records);
    }

    @Override
    public Actor findById(Integer id) {
        var record = this.dslContext
                .select().from(ACTOR).where(ACTOR.ACTOR_ID.eq(id))
                .fetchOne();
        if(record==null){
            log.error("Could not find actor");
            return null;
        }
        return ActorRowMapper.mapActorRecord(record);
    }

    @Override
    public void save(Actor actor) {

    }

    @Override
    public List<Actor> findAllByCategory(String category) {
        var records = dslContext
                .selectDistinct(ACTOR.ACTOR_ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
                .from(ACTOR)
                .join(FILM_ACTOR).on(ACTOR.ACTOR_ID.eq(FILM_ACTOR.ACTOR_ID))
                .join(
                    dslContext.select(FILM.FILM_ID).from(FILM)
                            .join(CATEGORY).on(FILM.CATEGORY_ID.eq(CATEGORY.CATEGORY_ID))
                            .and(CATEGORY.NAME.eq(category)).asTable("sub_films")
                ).on(FILM_ACTOR.FILM_ID.eq(DSL.field("sub_films.film_id",Integer.class))).fetch();
        return ActorRowMapper.mapActorRecord(records);
    }

    @Override
    public List<Actor> findAllByFilmReleaseYear(Integer year) {
        var records= dslContext
                .selectDistinct(ACTOR.ACTOR_ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
                .from(ACTOR)
                .join(FILM_ACTOR).on(ACTOR.ACTOR_ID.eq(FILM_ACTOR.ACTOR_ID))
                .join(FILM).on(FILM_ACTOR.FILM_ID.eq(FILM.FILM_ID))
                .and(FILM.RELEASE_YEAR.eq(year)).fetch();
        return ActorRowMapper.mapActorRecord(records);
    }
     */
}