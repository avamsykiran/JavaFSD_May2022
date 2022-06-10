MongoDB
---------------------------------------------------------

    What is MongoDB?
        NoSQL Database Management System

    Database Management System:
        Data Availablity
        Data Consistency
        Reliability
        Transaction Atomicity and Management

    Database Models
        Flat File Data Models               .csv,.xml,.json
        Network Data Models
        Hyrarchial Data Models
        Relational Data Models              oracle,ms access, ms sql server,...etc

    Graph Representation of Data         Hyrarchial Data Models
    ------------------------------------------------------------------

            D2H Portal
            -------------
                    Channel
                    Packages
                    Subscriber

                    Subscriber
                        has multiple Packages
                                        has a group of Channels
                
                    BSON - Binary Javascript object notation

                    Subscribers: [{
                        subId
                        subName
                        Packages : [{
                            packId:
                            activationDate:
                            validTillDate:
                            Channels:{[
                                chId:
                                chTitle:
                            ]}
                        }]

                    }]

    Relational Representation of Data         Relational Data Models
    ------------------------------------------------------------------

            D2H Portal
            -------------
                    Channel
                    Packages
                    Subscriber

                    Subscriber
                        has multiple Packages
                                        has a group of Channels
                
                    Subscribers         subId   SubNamne
                    Packages            packId  activationDate validTillDate subId(FK)
                    Channels            chId    chTitle packId(FK)
  

    Hyrarchial Data Model
    ----------------------[ noSQL ]

        MongoDB
        ChacheDB
        ....etc

    Lab Setup
    -----------------

        MongodB Server
        MongodB Client
        MongoDb Compass

                https://fastdl.mongodb.org/windows/mongodb-windows-x86_64-5.0.1-signed.msi
                https://fastdl.mongodb.org/osx/mongodb-macos-x86_64-5.0.2.tgz


    Start Your Server:
                            mongod --version
                            mongod --dbpath ./data
                            
    Start Your Commad Line Client
                            mongo
    
    GUI     Mongo Compass


    MongodB DB structure                        RDBMS DB Structure 
    --------------------------------------------------------------------
    Database                                        Database
        Collection                                      Table
            Documents                                       Record/Row/Tuple
                Fields and Document                                 Attributes/Col/Fields


    MongoDB Commands
    ---------------------------------------------------------------------

    use DATABASE_NAME               create or switch to a database
    db                              show the current database
    show dbs                        show all databases ; and a db is not visible unless
                                    it has atleast one document.
    db.dropDatabase()               is used to drop a existing database.

    db.createCollection(name)       is used to create a collection
    show collections                is used to list all the collections in the current db
    db.COLLECTION_NAME.drop()       is used to delete a collection completly

    db.COLLECTION_NAME.insertOne({})               one record will be inserted
    db.COLLECTION_NAME.insert({})
    db.COLLECTION_NAME.insertMany([{},{},{}])       bulk insertions
    db.COLLECTION_NAME.insert([{},{},{}])

    db.COLLECTION_NAME.update({"key":"value"}, {$set{"key":"newValue"}})                updates first matching record
    db.COLLECTION_NAME.findOneAndUpdate({"key":"value"}, {$set{"key":"newValue"}})
    db.COLLECTION_NAME.updateOne({"key":"value"}, {$set{"key":"newValue"}})
    db.COLLECTION_NAME.update({"key":"value"}, {$set{"key":"newValue"}},{multi:true})    updates all matching records
    db.COLLECTION_NAME.updateMany({"key":"value"}, {$set{"key":"newValue"})

    db.COLLECTION_NAME.save({_id:idValue,NEW_DATA})                                     replaces the entire record

    db.COLLECTION_NAME.remove({})                               remove all documents
    db.COLLECTION_NAME.remove({key:value})                      remove all matching documents
    db.COLLECTION_NAME.remove({key:value},1)                    remove first matching document
    db.COLLECTION_NAME.remove({key:value},{justOne:1})          remove first matching document

    db.COLLECTION_NAME.find()
    db.COLLECTION_NAME.find().pretty()
    db.COLLECTION_NAME.find({})                     find by example 
    db.COLLECTION_NAME.find({},{KEY:0/1})           projection of needed fields only
    db.COLLECTIONNAME.findOne({})                   retrive only first matching deocuemnt
    db.COLLECTION_NAME.find().limit(NUMBER)         limiting
    db.COLLECTION_NAME.find().limit(NUMBER).skip(NUMBER)
    db.COLLECTION_NAME.find().sort({KEY:1/0/-1})
    
    Opertion Cluases

        Operation	            Syntax	
        ============================================================================
        Equality	            {<key>:<value>}	
        Less Than	            {<key>:{$lt:<value>}}
        Less Than Equals	    {<key>:{$lte:<value>}}
        Greater Than	        {<key>:{$gt:<value>}}	
        Greater Than Equals	    {<key>:{$gte:<value>}}	
        Not Equals	            {<key>:{$ne:<value>}}	
        Values in an array	    {<key>:{$in:[<value1>, <value2>,……<valueN>]}}	
        Values not in an array	{<key>:{$nin:<value>}}	

        And                     { $and: [ {<key1>:<value1>}, { <key2>:<value2>} ] }
        Or                      { $or: [ {<key1>:<value1>}, { <key2>:<value2>} ] }
        Not                     { $NOT: [ {key1: value1}, {key2:value2} ] }

    //lets create a bulky collection to learn retrivals

    db.goods.insert([
        {_id:1,title:"Rice",unit:"25kg Bag",rate:2500,category:"CERALS"},
        {_id:2,title:"Palm Oil",unit:"1 Kg Packet",rate:500,category:"OIL"},
        {_id:3,title:"Olive Oil",unit:"1 Kg Packet",rate:5100,category:"OIL"},
        {_id:4,title:"Urd Dal",unit:"1 Kg Packet",rate:56,category:"PULSES"},
        {_id:5,title:"Channa Dal",unit:"1 Kg Packet",rate:67,category:"PULSES"},
        {_id:6,title:"Groudn Nuts",unit:"1 Kg Packet",rate:80,category:"PULSES"},
        {_id:7,title:"Wheat Flour",unit:"1 Kg Packet",rate:120,category:"FLOURS"},
        {_id:8,title:"Horlicks",unit:"1 Kg Bottle",rate:560,category:"BEVERAGES"},
        {_id:9,title:"Boost",unit:"1 Kg Bottle",rate:760,category:"BEVERAGES"},
        {_id:10,title:"Coke",unit:"600ml Can",rate:100,category:"BEVERAGES"},
        {_id:11,title:"Pepsi",unit:"600ml Can",rate:100,category:"BEVERAGES"},
        {_id:12,title:"Coke",unit:"1.5ltr Bottle",rate:100,category:"BEVERAGES"},
        {_id:13,title:"Pepsi",unit:"1.5ltr Bottle",rate:100,category:"BEVERAGES"},
        {_id:14,title:"Boat Mango",unit:"250ml Pack",rate:500,category:"BEVERAGES"},
        {_id:15,title:"Boat Multi Fruit",unit:"250ml Pack",rate:500,category:"BEVERAGES"},
        {_id:16,title:"Glucose",unit:"500g Pack",rate:500,category:"BEVERAGES"},
        {_id:17,title:"Vermicelli",unit:"500g Packet",rate:450,category:"OTHERS"},
        {_id:18,title:"Popcorn",unit:"50g Packet",rate:110,category:"OTHERS"},
        {_id:19,title:"Gulab Jamun Mix",unit:"500g Packet",rate:220,category:"OTHERS"},
        {_id:20,title:"Curd",unit:"500g Packet",rate:45,category:"OTHERS"}
    ])

    db.goods.find().limit(5)
    db.goods.find().limit(5).skip(5)
    db.goods.find().skip(db.goods.count()-5)
    db.goods.find({$and: [{rate:{$gt:100}},{category:"BEVERAGES"}] })
    db.goods.find({$and: [{rate:{$gt:70}},{rate:{$lt:700}},{category:{$in:["OIL","PULSES"]}}] })
    
    db.goods.find(
        {$or: 
            [ 
                {$and: [{category:"OIL"},{rate:{$lt:1000}}]},
                {$and: [{category:"PULSES"},{rate:{$lt:100}}]}, 
                {$and: [{category:"BEVERAGES"},{rate:{$gt:100}}]},
                {$and: [{category:"OTHERS"},{rate:{$lt:200}}]}
            ]
        }
    );

    db.goods.find(
        {$or: 
            [ 
                {$and: [{category:"OIL"},{rate:{$lt:1000}}]},
                {$and: [{category:"PULSES"},{rate:{$lt:100}}]}, 
                {$and: [{category:"BEVERAGES"},{rate:{$gt:100}}]},
                {$and: [{category:"OTHERS"},{rate:{$lt:200}}]}
            ]
        },
        {_id:0,title:1,category:1,rate:1}
    );

    db.goods.find(
        {$or: 
            [ 
                {$and: [{category:"OIL"},{rate:{$lt:1000}}]},
                {$and: [{category:"PULSES"},{rate:{$lt:100}}]}, 
                {$and: [{category:"BEVERAGES"},{rate:{$gt:100}}]},
                {$and: [{category:"OTHERS"},{rate:{$lt:200}}]}
            ]
        },
        {_id:0,title:1,category:1,rate:1}
    ).sort({category:1,rate:1});
    
    Aggregation Framework
    ==================================================================================================

        db.COLLECTION_NAME.aggregate(AN_ARRAY_OF_AGGREGATE_STAGES)

        Operation	            Syntax	
        ---------------------------------------------------------------------------------------------------
        $sum	                db.mycol.aggregate([{$group : {_id : "$grpcol", sumCol : {$sum : "$col"}}}])
        $avg	                db.mycol.aggregate([{$group : {_id : "$grpCol", avgCol : {$avg : "$col"}}}])
        $min	                db.mycol.aggregate([{$group : {_id : "$grpCol", minCol : {$min : "$col"}}}])
        $max	                db.mycol.aggregate([{$group : {_id : "$grpCol", maxCol : {$max : "$col"}}}])
        
        db.goods.aggregate([{$group : {_id : "$category", totalRate : {$sum : "$rate"}}}])
        db.goods.aggregate([{$group : {_id : "$category", avgRate : {$avg : "$rate"}}}])
        db.goods.aggregate([{$group : {_id : "$category", minRate : {$min : "$rate"}}}])
        db.goods.aggregate([{$group : {_id : "$category", maxRate : {$max : "$rate"}}}])
        
        Pipeline Operators
        ---------------------------------------------------------------------------------------------------
        $match          filtering  {expr: {filter expression}}
        $sort           sorting
        $group          grouping
        $limit          limiting
        $skip           skiping for pagiantions
        $project        projection
        $lookup         performs a left-outer join

                    $lookup:   {
                        from: <collection to join>,
                        localField: <field from the input documents>,
                        foreignField: <field from the documents of the "from" collection>,
                        as: <output array field>
                    }

        db.goods.aggregate([
            {$group : {_id : "$category", maxRate : {$max : "$rate"}}},
            {$sort:{maxRate:1}}
        ]);

        db.goods.aggregate([
                {$match:{rate:{$gte:150}}},
                {$group:{_id:"$category",sumRate:{$sum:"$rate"},avgRate:{$avg:"$rate"}}} ,
                {$match:{avgRate:{$gte:2000}}},
                {$project:{avgRate:1}}
        ]);

        db.goods.aggregate([{$group : {_id : "$unit", count : {$sum : 1}}}]);

        db.goods.aggregate([{$group : {_id : {category:"$category",unit:"$unit"}, count : {$sum : 1}}}]);

        db.orders.insert([
            {_id:1,goodId:1,qty:50},
            {_id:2,goodId:3,qty:5},
            {_id:3,goodId:3,qty:15},
            {_id:4,goodId:4,qty:6},
            {_id:5,goodId:2,qty:9},
            {_id:6,goodId:10,qty:12},
            {_id:7,goodId:7,qty:16},
            {_id:8,goodId:11,qty:17},
            {_id:9,goodId:12,qty:5}
        ])

        db.goods.aggregate([
            {
                $lookup:   {
                        from: "orders",
                        localField: "_id",
                        foreignField: "goodId",
                        as: "purchases"
                    }
            }
        ]).pretty()

        db.orders.aggregate([
            {
                $lookup:   {
                        from: "goods",
                        localField: "goodId",
                        foreignField: "_id",
                        as: "goodDetails"
                    }
            }
        ]).pretty();

    Mongo DB Data Types
    -------------------------------------------------------------
    string 
    int 
    boolean 
    arrays 
    object
    Date 
    Object ID 
    Binary data
    Code             This datatype is used to store JavaScript code into the document.


    Collection Schema Validation
    ------------------------------------------------------------------------

    db.createCollection("students", {
       validator: {
            $jsonSchema: {
                bsonType: "object",
                required: [ "name", "year", "major", "address" ],
                properties: {
                    name: {
                        bsonType: "string",
                        description: "must be a string and is required"
                    },
                    year: {
                        bsonType: "int",
                        minimum: 2017,
                        maximum: 3017,
                        description: "must be an integer in [ 2017, 3017 ] and is required"
                    },
                    major: {
                        enum: [ "Math", "English", "Computer Science", "History", null ],
                        description: "can only be one of the enum values and is required"
                    },
                    gpa: {
                        bsonType: "double",
                        description: "must be a double if the field exists"
                    },
                    address: {
                        bsonType: "object",
                        required: [ "city" ],
                        properties: {
                            street: {
                                bsonType: "string",
                                description: "must be a string if the field exists"
                            },
                            city: {
                                bsonType: "string",
                                description: "must be a string and is required"
                            }
                        }
                    }
                }
            }
        }
    })

    db.students.explain();

    Validating an exiting collection
    --------------------------------------------------------------------------------------------

    db.runCommand({
        collMod: "goods",
        validator: {
            $jsonSchema: {
                bsonType: "object",
                required: [ "title", "unit", "rate", "category" ],
                properties: {
                    title: {
                        bsonType: "string",
                        description: "must be a string and is required"
                    },
                    unit: {
                        bsonType: "string",
                        description: "must be a string and is required"
                    },
                    category: {
                        enum: [ "CERALS", "PULSES", "OIL", "Beverages", "OTHERS","FLOURS" ],
                        description: "can only be one of the enum values and is required"
                    },
                    rate: {
                        bsonType: "double",
                        description: "must be a double and is required"
                    }
                }
            }
        }
    })

    db.goods.validate()

    Sharding
    ----------------------------------------------------------------------

        is the mongodb's approach to ensure availability .

        Mongo database is partitioned accross multiple server called Shards.
        
        These 'Shards' run behind a running channel called 'Config Servers'.
        
        the config server will dictate where and how the Shards are executed and 
        alo thier runtime slots are managed by the config server.. 

        Query Server are those that actually mongod instacnes that keep track of
        the indexes of the data contained on the Shards. The query servers
        will be the ones that get hit by queries and these server will bring data
        from respective shards and compose them according to the query and then
        the results are responded.

        Router is a proxy server that takes care of communication between the
        query server and the shards.

                                                            ConfigServer                
                                                                |
                                                                |
                                                                |
                             QryServer3                       Shard2
                             QryServer2 ----> Routers ------> Shard1
        Client  ---------->  QryServer1                       Shard3  

    MongoDB with Java
    -----------------------------------------------------------------------
        https://www.mongodb.com/blog/post/getting-started-with-mongodb-and-java-part-i

    MongoDB with Python
    -----------------------------------------------------------------------
        https://www.mongodb.com/languages/python

    What is MongoDB Atlas
    -----------------------------------------------------------------------

        MongoDB Atlas is a fully-managed cloud database developed by the same people that build MongoDB. Atlas handles all the complexity of deploying, managing, and healing your deployments on the cloud service provider of your choice (AWS, Azure, and GCP).

    MongoDB Stitch
    -----------------------------------------------------------------------
            Autorization and authentication on MongoDB clouds. Used scale or scale down
            the manogdb managed instances.

    MongoDB Ops Manager
    -----------------------------------------------------------------------

            Creating or dropping mongodb instances for better scalalbility.
            it can also be used to bakcup and restore your mongodb instances.

    