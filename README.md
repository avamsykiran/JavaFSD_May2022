Full Stack Development
--------------------------------------------------------

    SDLC - Software Developmemt Life Cycle

        Analysis        - Purpose and Requirements - System Req Spacifications document
        Design          - Archetecture - UML (Unified Modeling Lanaguage) - Design doc
        Development     - Implementation - Source Code and Build Files or Packages
        Testing         - are these Pakages matching with the SRS
        Deployment      - distributing the product

        Maintenence

        Water Fall Model

            Analysis
                Design
                    Development
                            Testing
                                Deploymnet

        Incremental Model

            Analysis -> Design -> Development -> Testing -> Deployment -> Build 1 ( a min of 3 months to an year)
            Analysis -> Design -> Development -> Testing -> Deployment -> Build 2
            Analysis -> Design -> Development -> Testing -> Deployment -> Build 3
            Analysis -> Design -> Development -> Testing -> Deployment -> Build 4
            Analysis -> Design -> Development -> Testing -> Deployment -> Build 5
            Analysis -> Design -> Development -> Testing -> Deployment -> Build 6

        Agile Model

            Analysis -> Design -> Development -> Testing -> Deployment -> Sprint 1 ( a min of a week to an month)
            Analysis -> Design -> Development -> Testing -> Deployment -> Sprint 2
            Analysis -> Design -> Development -> Testing -> Deployment -> Sprint 3 ...

            Full Stack Developer is the one that all the skills needed
             for planning, desinging , developing, testing and deploying the product.

            Analysis            
            Design          Desgin Patterns , OOAD, UML
            Development     UI, BackEnd (apis), Persistence, UX
            Testing         Testing Terminology, Unit Testing, Mocking and Stubs, Integration Testing, e2e Testing
            Deploymnet      Dev-Ops
            
SCM - Source Code Management
-----------------------------------------------------------------

    SCM / SVM are repositories of code used to manage various versions and share them 
    across multiple stake holders.

        GIT is a very commonly used SCM

        remote repository               <------------->         local repository

        git cli     is a command line interface offering some commands to manage the repository


        git init    is used to initalize a folder as a local repository

        git add .   to add the files into the staging area.

        git status  to know the status of the repository

        git commit -m "message"         is used to seal the changes made to the files in the staging area.

        git log     the list of all the commits made so far

        git remote add origin "remote-repo-url"     is used to link a remore repo to our local repo

        git push origin master          to send all the commit made so far to the remote repo.

        git clone remote-repo-url       copy / download the remote repo to our local disk.

        git pull                        downlod the changes from remote into local repo.















