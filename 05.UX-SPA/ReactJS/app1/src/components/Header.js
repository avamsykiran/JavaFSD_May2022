
const Header = ({appTitle,appTag,builders}) => (
    <header>
        <h3>
            {appTitle} <br />
            <small>{appTag}</small>
        </h3>
        <h4>Team</h4>
        <ol>
            {builders.map(a => (<li key={a}>{a}</li>))}
        </ol>
    </header>
);

export default Header;