
const Home = () => {
    return (
        <section className='container-fluid p-4'>
            <h4>Hello All! Welcoem To My React SPA</h4>

            <p className='alert alert-info p-3'>
                SPA - <strong>Single Page Application</strong> is an Application
                that has only one page and all the activities are handled in that
                page itself. Any form submitions, links, events and everything else
                happens in the same page and handled by the javascript code associated
                with it.
            </p>

            <p>
                This application is a income-statmeent application that enables different
                account holders to manage their debit and credit transactions.
            </p>

            <p>
                A list of account holders can be retrived added and updated.
            </p>

            <p>
                Each account holder can add, update, delete and retrive his
                transactions list.
            </p>
        </section>
    );
}

export default Home;